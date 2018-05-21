package sk.ness.interview.utils;

public class Constants {

    //region General constants
    public static final String NAME_SESSION_FACTORY = "sessionFactory";
    //endregion

    //region Table Columns
    public static final int COLUMN_PRECISION_10 = 10;
    public static final int COLUMN_LENGTH_50 = 50;
    public static final int COLUMN_LENGTH_2000 = 2000;
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_COMMENT_ID = "commentId";
    public static final String COLUMN_NAME_AUTHOR = "author";
    public static final String COLUMN_NAME_TEXT = "text";
    public static final String COLUMN_NAME_CREATE_TIMESTAMP = "create_timestamp";
    //endregion

    //region Table Comments
    public static final String TABLE_COMMENTS = "comments";
    public static final String COMMENTS_SEQUENCE_NAME = TABLE_COMMENTS + "_seq";
    public static final String COMMENTS_SEQUENCE_GENERATOR_NAME = COMMENTS_SEQUENCE_NAME + "_store";
    public static final String SELECT_ALL_COMMENTS = "select * from " + TABLE_COMMENTS;
    //endregion

    //region Api Requests Comments
    public static final String API_GET_COMMENTS = TABLE_COMMENTS;
    public static final String API_GET_COMMENT_BY_ID = API_GET_COMMENTS + "/{commentId}";
    public static final String API_SEARCH_COMMENT = API_GET_COMMENTS + "/search/{searchText}";
    public static final String API_ADD_COMMENT = API_GET_COMMENTS + "/add";
    //endregion
}
