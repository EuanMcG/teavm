package org.teavm.classlib.java.lang;

import org.teavm.classlib.java.io.TPrintStream;
import org.teavm.classlib.java.lang.reflect.TArray;
import org.teavm.javascript.ni.GeneratedBy;

/**
 *
 * @author Alexey Andreev
 */
public final class TSystem extends TObject {
    public static final TPrintStream out = new TPrintStream(new TConsoleOutputStream_stdout(), false);
    public static final TPrintStream err = new TPrintStream(new TConsoleOutputStream_stderr(), false);

    private TSystem() {
    }

    public static void arraycopy(TObject src, int srcPos, TObject dest, int destPos, int length) {
        if (src == null || dest == null) {
            throw new TNullPointerException(TString.wrap("Either src or dest is null"));
        }
        if (src.getClass() != dest.getClass()) {
            throw new TArrayStoreException();
        }
        if (srcPos < 0 || destPos < 0 || length < 0 || srcPos + length > TArray.getLength(src) ||
                destPos + length > TArray.getLength(dest)) {
            throw new TIndexOutOfBoundsException();
        }
        doArrayCopy(src, srcPos, dest, destPos, length);
    }

    @GeneratedBy(SystemNativeGenerator.class)
    private static native void doArrayCopy(Object src, int srcPos, Object dest, int destPos, int length);
}
