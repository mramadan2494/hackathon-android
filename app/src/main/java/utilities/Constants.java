package utilities;


import okhttp3.MediaType;

/**
 * Created by yousefzakher on 9/17/15.
 */
public class Constants {

    public static final String FONT_AWESOME_WEBFONT_TTF = "fontawesome-webfont.ttf";

    public static final String FONT_ROBOTOCONDENSED_TTF = "RobotoCondensed-Bold.ttf";

    public static final String ROBOTO_LIGHT_REGULAR = "ROBOTO-LIGHT.TTF";

    public static final String ROBOTO_BOLD = "Roboto-Bold.ttf";

    public static final String BADGE_FRAGMENT_TAG = "BADGE_FRAGMENT_TAG";

    public static final String TUTORIAL_FIRSTTIME_LOCK = "Tutorial_FirstTime";

    public static String FAKE_IMAGE_URL = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTClWGh33UoGa8GwP6Ls_iZWMvq5qhtB_baFqqcdmxXSHRlOyak5TwM-Ik";


    /* Be sure to fill in the two strings below. */
    // Shared Preferences
    public static final String SHARED_PREFERENCES_NAME = "shared";
    public static final String SHARED_PREFERENCES_NAME_PUSH_NOTIFICATION = "pushShared";

    // SYNC
    public static final String SYNC_LAST_TIME_STAMP = "last_updated_time";
    public static final int SYNC_STATUS_SUCCESS = 1;
    public static final int SYNC_STATUS_FAIL = 0;



    // Loaders Ids
    // Store Activity
    public static final int LOADER_STORE_MY_POINTS_FRAGMENT_FETCH_DATA = 1;
    public static final int LOADER_STORE_MENU_FRAGMENT_FETCH_DATA = 2;
    public static final int LOADER_STORE_ABOUT_FRAGMENT_FETCH_DATA = 3;
    // Customer Home Activity
    public static final int LOADER_CUSTOMER_HOME_FRAGMENT_FETCH_DATA = 4;
    public static final int LOADER_CUSTOMER_LOG_FRAGMENT_FETCH_DATA = 5;
    public static final int LOADER_CUSTOMER_SETINGS_FRAGMENT_FETCH_DATA = 6;




    /**
     * Application root directory. All media files wi'll be stored here.
     */
    public static final String APPLICATION_DIR_NAME = "ShopX";

    /**
     * Application folder for video files
     */
    public static final String VIDEO_COMPRESSOR_COMPRESSED_VIDEOS_DIR = "/Compressed Videos/";

    /**
     * Application folder for Temp video files
     */
    public static final String VIDEO_COMPRESSOR_TEMP_DIR = "/Temp/";

    //public static final String BASE_URL = "https://backdev.shopxgo.com";//"http://www.mocky.io";
    public static final String BASE_URL = "http://178.79.180.111/hackathon-backend/";//"http://www.mocky.io";
    public static final String PRIVACY_POLICY_URL = "http://shopxgo.com/shopx-go-privacy-policy.html";
    public static final String SHOPX_FACEBOOK_URL = "https://www.facebook.com/shopxapp";

    // public static final String MOCKY_URL = "http://www.mocky.io";//"https://backdev.shopxgo.com";


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static final int fakeView = -1; // use at then end of news recycler view instead of progress dialog

    public static final int NEW_POINTS_POPUP_LIMIT = 3;

    public static class Priority {
        public static int LOW = 0;
        public static int MID = 500;
        public static int HIGH = 1000;
    }

    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // Push notification constants
    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";
    public static final String PUSH_NOTIFICATION_OPEN_SEARCH_SCREEN ="7";
    public static final String PUSH_NOTIFICATION_OPEN_REMINDER_EXPIRATION_POPUP ="6";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;





}
