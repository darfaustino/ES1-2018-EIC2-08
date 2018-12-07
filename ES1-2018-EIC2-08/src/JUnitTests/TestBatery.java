package JUnitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BackupFPosts.class, BackupMail.class, BackupTweets.class, ChangeMail_change.class,
		ChangeMail_init.class, ChangeName_change.class, ChangeName_init.class, ChangePass_change.class,
		ChangePass_init.class, ContainsFilter_filter.class, DateFilter_filter.class, Face_getExtendedAccessToken.class,
		Face_getLikedPages.class, Face_getTimeLinePosts.class, Face_getUserInformation.class,
		FacebookPost_getFacePost.class, FacePost_getDate.class, FacePost_getId.class, FacePost_getMessage.class,
		FacePost_getPost.class, FacePost_getStory.class, FetchFromBackup.class, getTextFromMessage.class,
		getTextFromMimeMultipart.class, InitContainsFilter.class, InitDateFilter.class, InitEmailSingular.class,
		InitGuiResponse.class, InitHome.class, InitLogin.class, InitMainTimeline.class, InitSignUp.class,
		InitUserFilter.class, isFacebookOnline.class, isMailOnline.class, isTwitterOnline.class, LoginMail.class,
		Mail_FetchFromBackup.class, OpenMailForm.class, PostsList.class, SaveXML.class, Tweet_init.class,
		Twitter_FetchFromBackup.class, Twitter_getTimeLine.class, Twitter_initTwitter.class, Twitter_retweet.class,
		TwitterTimelineInit.class, UserFilter_filter.class })
public class TestBatery {

}
