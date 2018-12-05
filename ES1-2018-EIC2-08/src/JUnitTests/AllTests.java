package JUnitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Face_getExtendedAccessToken.class, Face_getLikedPages.class, Face_getTimeLinePosts.class,
		Face_getUserInformation.class, FacebookPost_getFacePost.class, FacePost_getDate.class, FacePost_getId.class,
		FacePost_getMessage.class, FacePost_getPost.class, FacePost_getStory.class, FaceTimeline_getFacebook.class,
		getTextFromMessage.class, getTextFromMimeMultipart.class, InitEmailSingular.class, InitEmailTimeline.class,
		InitGuiResponse.class, InitHome.class, InitLogin.class, InitMainTimeline.class, InitSignUp.class,
		LoginMail.class, OpenMailForm.class, SaveXML.class, Tweet_init.class, Twitter_getTimeLine.class,
		Twitter_initTwitter.class, Twitter_retweet.class, BackupFPosts.class, BackupMail.class, BackupTweets.class, FetchFromBackup.class,
		isFacebookOnline.class, isMailOnline.class, isTwitterOnline.class, Mail_FetchFromBackup.class, Twitter_FetchFromBackup.class,
		PostsList.class, })
public class AllTests {

}
