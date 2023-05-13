package braid.society.secret.drsreloaded.api.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Nonnull;

@Slf4j
public class CountingThreadFactory implements ThreadFactory {

  private final Supplier<String> specifier;
  private final AtomicLong counter = new AtomicLong(1);
  private final boolean isDaemon;

  private static final String APP_IDENTIFIER = "Thread";
  private static final Supplier<String> DEFAULT_SPECIFIER = () -> "default thread";

  // delete this constructor if it won't be used
  public CountingThreadFactory(Supplier<String> specifier) {
    this(specifier, true);
  }

  public CountingThreadFactory(Supplier<String> specifier, boolean isDaemon) {
    this.specifier = () -> APP_IDENTIFIER + "-" + specifier.get();
    this.isDaemon = isDaemon;
  }

  /**
   * Constructs a new {@code Thread}.  Implementations may also initialize priority, name, daemon
   * status, {@code ThreadGroup}, etc.
   *
   * @param r a runnable to be executed by new thread instance
   * @return constructed thread, or {@code null} if the request to create a thread is rejected
   */
  @Override
  public Thread newThread(@Nonnull Runnable r) {
    final Thread t = new Thread(r, specifier.get() + "-Worker " + counter.getAndIncrement());
    t.setDaemon(this.isDaemon);
    return t;
  }
}
