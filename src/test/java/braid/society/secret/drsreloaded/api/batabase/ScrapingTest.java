package braid.society.secret.drsreloaded.api.batabase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import braid.society.secret.drsreloaded.api.database.IScraping;
import braid.society.secret.drsreloaded.api.database.Song;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScrapingTest {

  @Test
  void test() {
    IScraping scraping = mock(IScraping.class);
    List<Song> mockedList = List.of(
        new Song("song1", "All", true, false, false, false, "2021-01-01"),
        new Song("song2", "Cu", false, true, false, false, "2021-01-02"),
        new Song("song3", "Co", false, false, true, false, "2021-01-03"),
        new Song("song4", "Pa", false, false, false, true, "2021-01-04"),
        new Song("song5", "All", true, true, true, true, "2021-01-05")
    );

    when(scraping.scrape()).thenReturn(mockedList);

    List<Song> scrapedList = scraping.scrape();
    System.out.println(scrapedList);

    assertEquals(scrapedList, mockedList);

    verify(scraping, times(1)).scrape();
  }
}
