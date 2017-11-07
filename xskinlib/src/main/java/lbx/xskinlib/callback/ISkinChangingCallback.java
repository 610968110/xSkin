package lbx.xskinlib.callback;

public interface ISkinChangingCallback {
    void onStart();

    void onError(Exception e);

    void onComplete();

    DefaultThemeChangingCallback DEFAULT_CALLBACK = new DefaultThemeChangingCallback();

    class DefaultThemeChangingCallback implements ISkinChangingCallback {
        @Override
        public void onStart() {

        }

        @Override
        public void onError(Exception e) {

        }

        @Override
        public void onComplete() {

        }
    }
}
