package braid.society.secret.drsreloaded.internal.concurrent;

import java.util.concurrent.ThreadFactory;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ConcurrencyUtil {

  public static ThreadFactory createThreadFactory(String threadSpecifier, boolean daemon) {
    return new CountingThreadFactory(() -> threadSpecifier, daemon);
  }
}
