package braid.society.secret.drsreloaded.internal.database;

import braid.society.secret.drsreloaded.api.database.IScraping;
import braid.society.secret.drsreloaded.api.database.Song;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Slf4j
public class Scraping implements IScraping {

  public Scraping() {
    log.info("Start initializing scraping.");
  }

  @Nonnull
  protected <T> T filtering(@Nonnull Elements elements, @Nonnull String className,
      @Nonnull Function<Element, T> mapper, @Nonnull T defaultValue) {
    return elements.parallelStream().filter(c -> c.hasClass(className)).findFirst().map(mapper)
        .orElse(defaultValue);
  }

  @Nonnull
  protected Stream<Song> mappingDocument(@Nonnull Element row) {
    Elements columns = row.getElementsByTag("td");
    String name = filtering(columns, "mu__table--col1", Element::text, "UNKNOWN");
    String type = filtering(columns, "mu__table--col2", Element::text, "UNKNOWN");
    boolean doesMasterPlusExist = filtering(columns, "mu__table--col4", Element::hasText, false);
    boolean doesWitchExist = filtering(columns, "mu__table--col5", Element::hasText, false);
    boolean doesGrandExist = filtering(columns, "mu__table--col6", Element::hasText, false);
    boolean doesSmartExist = filtering(columns, "mu__table--col7", Element::hasText, false);
    String publishDate = filtering(columns, "mu__table--col8", Element::text, "1900/01/01");
    return Stream.of(
        new Song(name, type, doesMasterPlusExist, doesWitchExist, doesGrandExist, doesSmartExist,
            publishDate));
  }

  @Override
  public List<Song> scrape() {
    Document doc;
    try {
      doc = this.fetchDocument(DatabaseUtil.getScrapingSiteLink());
    } catch (IOException e) {
      log.error("Error while fetching document.", e);
      return Collections.emptyList();
    }

    Elements tableRows = Objects.requireNonNull(doc.getElementsByTag("table").first())
        .getElementsByTag("tr");
    tableRows.remove(0); // remove header row
    return this.parseTableRows(tableRows);
  }

  @Nonnull
  protected List<Song> parseTableRows(@Nonnull Elements rows) {
    return rows.parallelStream().flatMap(this::mappingDocument).collect(Collectors.toList());
  }

  @Nonnull
  private Document fetchDocument(@Nonnull String link) throws IOException {
    return Jsoup.connect(link).timeout(0).maxBodySize(0).get();
  }

  @Override
  public String getUrl() {
    return DatabaseUtil.getScrapingSiteLink();
  }
}
