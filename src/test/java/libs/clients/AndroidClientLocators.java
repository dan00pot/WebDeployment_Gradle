/*
This class contains locator of Elements in Avaya Equinox Android Client.
Author		: Quan Nguyendsadasd
 */
package libs.clients;

import org.openqa.selenium.By;

public class AndroidClientLocators {

	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS IN FIRST
	// SCREEN WHEN LAUNCHING ANDROID CLIENT##################
	// ###########################################################################################################################
	public By FIRST_SCREEN_SETTING_BTN = By
			.id("com.avaya.android.flare:id/settings_icon");
	public By FIRST_SCREEN_SETTING_USE_MANUL_BTN = By
			.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]");
	public By FIRST_SCREEN_SETTING_MANUALLY_CONF_BTN = By
			.name("Manually configure");
	public By FIRST_SCREEN_SETTING_USE_WEB_BTN = By
			.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]");
	// public By FIRST_SCREEN_MENU_BTN = By.name("Open Navigation Drawer");
	public By FIRST_SCREEN_MENU_BTN = By
			.xpath("//android.widget.ImageButton[contains(@content-desc,'Open Navigation Drawer')]");

	// public By FIRST_SCREEN_MENU_BTN =
	// By.xpath("//*[contains(@content-desc,'Open Navigation Drawer')]");
	public By FIRST_SCREEN_MENU_SETTING_BTN = By
			.id("com.avaya.android.flare:id/nav_header_settings");

	public By firstScreenMenuTabLocators(String tabName) {
		return By.xpath("//android.widget.TextView[contains(@text,'" + tabName
				+ "')]");
	}

	public By FIRST_SCREEN_MENU_NEW_MSG_COUNT = By
			.xpath("//android.widget.FrameLayout[@index='5']/android.widget.LinearLayout/android.widget.TextView[@index='2']");

	public By firstScreenMenuTabImageLocators(String tabName) {
		return By.xpath("//android.widget.TextView[@text = '" + tabName
				+ "']/../android.widget.ImageView");
	};

	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS IN SETTING
	// SCREEN##############################################
	// ###########################################################################################################################

	public By settingScreenTabLocators(String tabName) {
		return By.xpath("//android.widget.TextView[contains(@text,'" + tabName
				+ "')]");
	};

	public By SETTING_SCREEN_CONTACT_TAB = By.name("Contacts");

	public By settingScreenOptionsInsideTabLocators(String option) {
		return By.xpath("//android.widget.TextView[contains(@text,'" + option
				+ "')]");
	}

	public By SETTING_SCREEN_DONE_BTN = By
			.id("com.avaya.android.flare:id/toolbar_done");
	public By SETTING_SCREEN_BACK_BTN = By
			.id("com.avaya.android.flare:id/toolbar_up");

	public By SETTING_SCREEN_SERVICES = By
			.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]/android.widget.RelativeLayout");
	public By SETTING_SCREEN_SERVICES_TAB_SERVICE_DETAILS_SWITCH = By
			.className("android.widget.Switch");
	public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICE_ON_OFF_SWITCH = By
			.id("com.avaya.android.flare:id/voip_login_enabled");

	// TrucNguyen
	public By SETTING_SCREEN_SERVICES_TAB_EXCHANGE_CALENDAR_SWITCH = By
			.id("com.avaya.android.flare:id/ews_login_enabled");
	public By SETTING_SCREEN_SERVICES_TAB_AVAYA_CLOUD_SERVICES_SWITCH = By
			.id("com.avaya.android.flare:id/zang_enabled_switch");
	public By SETTING_SCREEN_SERVICES_TAB_CES_SWITCH = By
			.id("com.avaya.android.flare:id/ces_login_enabled");

	// end

	public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_SV_ADDRESS_TXT = By
			.id("com.avaya.android.flare:id/voip_server");
	public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_DOMAIN_TXT = By
			.id("com.avaya.android.flare:id/voip_domain");
	public By SETTING_SCREEN_SERVICES_TAB_PHONE_SERVICES_SV_PORT_TX = By
			.id("com.avaya.android.flare:id/voip_port");

	public By SETTING_SCREEN_SERVICES_TAB_MM_ON_OFF_TOGGLE = By
			.id("com.avaya.android.flare:id/enterprise_messaging_switch");
	public By SETTING_SCREEN_SERVICES_TAB_MM_SV_ADDRESS_TXT = By
			.id("com.avaya.android.flare:id/enterprise_messaging_server");
	public By SETTING_SCREEN_SERVICES_TAB_MM_SV_PORT_TXT = By
			.id("com.avaya.android.flare:id/enterprise_messaging_port");

	public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_USERNAME_TXT = By
			.id("com.avaya.android.flare:id/sso_service_username");
	public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_PASSWORD_TXT = By
			.id("com.avaya.android.flare:id/sso_service_password");
	public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_CONNECT_BTN = By
			.id("com.avaya.android.flare:id/sso_service_connect_button");
	public By SETTING_SCREEN_ACCOUNT_TAB_COMMUNICATOR_CONNECTED_TXT = By
			.id("com.avaya.android.flare:id/service_connected_as_user");

	public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_EXTENSION_TXT = By
			.id("com.avaya.android.flare:id/voip_service_username");
	public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_PASSWORD_TXT = By
			.id("com.avaya.android.flare:id/voip_service_password");
	public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_SERVICE_CONNECT_BTN = By
			.id("com.avaya.android.flare:id/voip_service_connect_button");
	public By SETTING_SCREEN_ACCOUNT_TAB_PHONE_SERVICE_CONNECTED_TXT = By
			.id("com.avaya.android.flare:id/voip_service_connected_as_user");

	public By SETTING_SCREEN_POP_UP_APPLY_CHANGES_BTN = By
			.xpath("//android.widget.TextView[@text = 'Apply Changes']");
	public By SETTING_SCREEN_POP_UP_CONTINUE_EDITING_BTN = By
			.xpath("//android.widget.TextView[@text = 'Continue Editing']");
	public By SETTING_SCREEN_POP_UP_UNDO_CHANGES_BTN = By
			.xpath("//android.widget.TextView[@text = 'Undo Changes']");

	public By SETTING_SCREEN_SERVICES_TAB_DEVICE_SERVICE_SV_ADDRESS_TXT = By
			.id("com.avaya.android.flare:id/acs_server");
	public By SETTING_SCREEN_SERVICES_TAB_DEVICE_SERVICE_SV_PORT_TXT = By
			.id("com.avaya.android.flare:id/acs_port");

	public By SETTING_SCREEN_SERVICES_TAB_MM_POLLING_INTERVAL_TXT = By
			.id("com.avaya.android.flare:id/messaging_spinner_item_text");

	public By SETTING_SCREEN_SUPPORT_RESET_APPLICATION_BTN = By
			.xpath("//android.widget.TextView[@text = 'Reset Application']");

	public By SETTING_SCREEN_SUPPORT_RESET_APPLICATION_OK_BTN = By
			.id("android:id/button1");

	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS IN MESSAGES
	// SCREEN#############################################
	// ###########################################################################################################################
	public By messagesScreenUserNameLocators(String userName) {
		return By.xpath("//android.widget.TextView[@text='" + userName + "']");
	}

	public By messagesScreenConversationNameLocators(String conversationName) {
		return By.xpath("//android.widget.TextView[@text='" + conversationName
				+ "']");
	}

	public By messagesScreenConversationNameLocatorsWhenExistCall(
			String conversationName) {
		return By.xpath("//android.widget.TextView[@text='" + conversationName
				+ "']/../../..");
	}

	public By messagesScreenConversationContentLocators(String conversationName) {
		return By
				.xpath("//android.widget.TextView[@text = '"
						+ conversationName
						+ "']/../..//android.widget.TextView[@resource-id = 'com.avaya.android.flare:id/tvMessage']");
	}

	public By messagesScreenConversationAttachmentIconLocators(
			String conversationName) {
		return By
				.xpath("//android.widget.TextView[@text = '"
						+ conversationName
						+ "']/..//android.widget.ImageView[@resource-id = 'com.avaya.android.flare:id/ivAttachment']");
	}

	public By messagesScreenConversationTimeLocators(String conversationName) {
		return By
				.xpath("//android.widget.TextView[@text = '"
						+ conversationName
						+ "']/..//android.widget.TextView[@resource-id = 'com.avaya.android.flare:id/tvTime']");
	}

	public By messagesScreenConversationDisplayedContentLocators(
			String conversationName, String content) {
		return By.xpath("//android.widget.TextView[@text = '"
				+ conversationName
				+ "']/../..//android.widget.TextView[@text = '" + content
				+ "']");
	}

	public By messageScreenTypingStatus(String user) {
		return By
				.xpath("//android.widget.TextView[contains(@resource-id,'com.avaya.android.flare:id/messaging_user_is_typing') and @text = '"
						+ user + " is typing …']");
	}

	public By messageScreenLeftNotification(String user) {
		return By
				.xpath("//android.widget.TextView[contains(@resource-id,'com.avaya.android.flare:id/messaging_user_message_content') and @text = '"
						+ user + " left the conversation']");
	}

	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS IN CONTACT
	// DETAIL SCREEN##################################
	// ###########################################################################################################################

	public By CONTACT_DETAILS_PHONE_NUMBER = By
			.id("contact_details_phone_number");
	public By CONTACT_DETAILS_PHONE_NUMBER1 = By
			.id("com.avaya.android.flare:id/contact_details_phone_number");

	public By CONTACT_DETAILS_MAIL = By.id("contact_details_email");

	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS IN
	// CONVERSATION DETAIL SCREEN##################################
	// ###########################################################################################################################

	public By CONVERSATION_DETAILS_SCREEN_BACK_MESSAGING_TAB_BTN = By
			.className("android.widget.ImageButton");
	public By CONVERSATION_DETAILS_SCREEN_MAKE_AUDIO_CALL = By
			.id("com.avaya.android.flare:id/iv_call_audio");
	public By CONVERSATION_DETAILS_SCREEN_MAKE_VIDEO_CALL = By
			.id("com.avaya.android.flare:id/iv_call_video");
	public By CONVERSATION_DETAILS_SCREEN_MAKE__CALL_NAME_LIST = By
			.id("com.avaya.android.flare:id/list_item_name");
	public By CONVERSATION_DETAILS_SCREEN_MSG_TXT = By
			.id("com.avaya.android.flare:id/messaging_message_input");
	public By CONVERSATION_DETAILS_SCREEN_ATTACH_BTN = By
			.id("com.avaya.android.flare:id/messaging_message_attachment_button");
	public By CONVERSATION_DETAILS_SCREEN_SEND_BTN = By
			.id("com.avaya.android.flare:id/messaging_message_send_button");
	public By CONVERSATION_DETAILS_SCREEN_SUBJECT_TXT = By
			.id("com.avaya.android.flare:id/et_conversation_subject");
	public By CONVERSATION_DETAILS_SCREEN_SUBJECT_DONE_BTN = By
			.id("com.avaya.android.flare:id/tv_done");
	public By CONVERSATION_DETAILS_SCREEN_REPLAY_BTN = By
			.id("messaging_audio_player_play_button");

	public By conversationDetailScreenAttachmentActionsLocator(String actions) 
	{
		return By.xpath("//android.widget.TextView[@text = '" + actions + "']");
	}

	public By CONVERSATION_DETAILS_SCREEN_RECORD_AUDIO_START_STOP_BTN = By
			.id("com.avaya.android.flare:id/record_stop_button");
	public By CONVERSATION_DETAILS_SCREEN_AUDIO_MSG_USE_BTN = By
			.id("com.avaya.android.flare:id/messaging_audio_player_use_button");
	public By CONVERSATION_DETAILS_SCREEN_AUDIO_MSG_DISCARD_BTN = By
			.id("com.avaya.android.flare:id/messaging_audio_player_discard_button");
	public By CONVERSATION_DETAILS_SCREEN_RECORD_VIDEO_REPLAY_BTN = By
			.id("com.avaya.android.flare:id/play_preview_video_button");
	public By CONVERSATION_DETAILS_SCREEN_RECORD_VIDEO_START_STOP_BTN = By
			.id("com.avaya.android.flare:id/record_stop_button");
	// public By CONVERSATION_DETAILS_SCREEN_VIDEO_MSG_USE_BTN =
	// By.id("com.avaya.android.flare:id/acceptMediaRecording");
	public By CONVERSATION_DETAILS_SCREEN_VIDEO_MSG_USE_BTN = By
			.id("com.avaya.android.flare:id/acceptMediaRecording");

	public By CONVERSATION_DETAILS_SCREEN_VIDEO_MSG_DISCARD_BTN = By
			.id("com.avaya.android.flare:id/rejectMediaRecording");
	public By CONVERSATION_DETAILS_SCREEN_VIDEO = By.id("content");
	public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_PRESS_BTN = By
			.id("com.lge.camera:id/shutter_bottom_comp_type");
	public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_PRESS_BTN_GALAXYJ7PRIME = By
			.xpath("//*[@text = 'Shutter']");
	public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_BACK_BTN = By
			.id("com.lge.camera:id/back_button");
	// public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_OK_BTN =
	// By.id("com.lge.camera:id/btn_ok");
	// public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_CANCEL_BTN =
	// By.id("ccom.lge.camera:id/btn_cancel");
	public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_OK_BTN = By
			.xpath("//android.widget.Button[@text= 'OK']");
	public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_OK_BTN_GALAXYJ7PRIME = By
			.xpath("//android.widget.TextView[@text= 'OK']");
	public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_CANCEL_BTN = By
			.xpath("//android.widget.Button[@text= 'CANCEL']");

	public By conversationDetailScreenFileNameLocator(String fileName) {
		return By
				.xpath("//android.widget.TextView[@text = '" + fileName + "']");
	}

	public By conversationDetailScreenTextMessageLocator(String textMessage) {
		return By.xpath("//android.widget.TextView[@text = '" + textMessage
				+ "']");
	}

	public By conversationDetailScreenContainsTextMessageLocator(
			String textMessage) {
		return By.xpath("//android.widget.TextView[contains(@text, '"
				+ textMessage + "')]");
	}

	public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_RETRY_BTN = By
			.xpath("//android.widget.TextView[@text='Retry']");
	public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_SHUTTER_BTN = By
			.xpath("//GLButton[@text='Shutter']");

	public By conversationDetailScreenConversationNameLocators(
			String conversationName) {
		return By.xpath("//android.widget.TextView[@text = '"
				+ conversationName + "']");
	}

	public By CONVERSATION_DETAILS_SCREEN_LEAVE_CONVERSATION_BTN = By
			.xpath("//android.widget.TextView[@text = 'Leave Conversation']");
	public By CONVERSATION_DETAILS_SCREEN_LEAVE_CONVERSATION_OK_BTN = By
			.xpath("//android.widget.Button[@text = 'OK']");

	public By CONVERSATION_DETAILS_SCREEN_SUBJECT_TITLE_TXT = By
			.id("com.avaya.android.flare:id/tv_title");
	public By CONVERSATION_DETAILS_EDIT_SUBJECT_BTN = By
			.xpath("//android.widget.TextView[@text = 'Edit Subject']");
	public By CONVERSATION_DETAILS_SCREEN_ADD_PARTICIPANT_BTN = By
			.xpath("//android.widget.TextView[@text = 'Add Participant']");
	public By CONVERSATION_DETAILS_SCREEN_VIEW_PARTICIPANT_LIST_BTN = By
			.xpath("//android.widget.TextView[contains(@text, 'View Participant List')]");
	public By conversationWindowsAudiofile = By
			.xpath("//*[contains(@text,'AUD')]");
	public By conversationWindowsPhotofile = By
			.xpath("//*[contains(@text,'.jpg')]");
	public By conversationWindowsVideofile = By
			.xpath("//*[contains(@text,'VID')]");
	public By conversationWindowsVideofileiOS = By
			.xpath("//*[contains(@text,'.mp4')]");
	public By CONVERSATION_DETAILS_SCREEN_MESSAGE_CONTENT_TXT = By
			.id("com.avaya.android.flare:id/messaging_user_message_content");
	public By CONVERSATION_DETAILS_ATTACHMENT = By
			.id("messaging_attachment_layout");
	public By MESSAGE_SCREEN_MARK_READ = By
			.xpath("//android.widget.TextView[@text='Mark All as Read']");
	// ###########################################################################################################################
	// ######################################## LOCATOR OF ELEMENTS IN ATTACH A
	// FILE SCREEN #########################
	// ###########################################################################################################################
	public By PROGRESS_BAR = By.id("adprogress_progressBar");
	public By ATTACH_DOWNLOADS = By.xpath("//*[@text='Downloads']");

	public By ATTACH_DOWNLOADS_FILE(String filename) {
		return By.xpath("//android.widget.TextView[@text='" + filename + "']");
	}

	public By MESSAGE_SCREEN_ATTACHMENT_REVIEW = By
			.id("com.avaya.android.flare:id/iv_attachment_preview");
	public By ATTACH_LIST_OPTION = By
			.id("com.android.documentsui:id/menu_list");
	public By ATTACH_ROOT_BTN = By
			.xpath("//android.widget.ImageButton[contains(@content-desc,'Show roots')]");
	public By ATTACH_LIST_ITEM_LAST = By
			.xpath("//*[@id='com.android.documentsui:id/dir_list']//com.android.documentsui[last()]");
	public By ATTACH_LIST_ITEM_FIRST = By
			.xpath("//*[@id='com.android.documentsui:id/dir_list']//com.android.documentsui[first()]");
	public By ATTACH_SORT_ARROW = By
			.id("com.android.documentsui:id/sort_arrow");
	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS IN ADD
	// PARTICIPANT CONVERSATION SCREEN#########################
	// ###########################################################################################################################
	public By conversationWindowsAudiofileiOS = By
			.xpath("//*[contains(@text,'.m4a')]");
	public By CONVERSATION_DETAILS_SCREEN_ADD_PARTICIPANT_CONTACT_SEARCH_TXT = By
			.id("com.avaya.android.flare:id/unifiedContactsSearchEditText");
	public By CONVERSATION_DETAILS_SCREEN_ADD_PARTICIPANT_SELECT_CONTACT_BTN = By
			.id("com.avaya.android.flare:id/pickerButton");

	public By CONVERSATION_DETAILS_SCREEN_ADD_PARTICIPANT_BACK_BTN = By
			.id("com.avaya.android.flare:id/unifiedContactsSearchCancel");
	public By CONVERSATION_DETAILS_SCREEN_ADD_PARTICIPANT_NEXT_BTN = By
			.id("com.avaya.android.flare:id/tv_contact_picker_header_action");
	public By CONVERSATION_DETAILS_SCREEN_ADD_PARTICIPANT_ADD_BTN = By
			.id("com.avaya.android.flare:id/tv_contact_group_selection_header_action");
	public By CONVERSATION_DETAILS_SCREEN_ADD_INVALID_PARTICIPANT_TITLE_TXT = By
			.xpath("//android.widget.TextView[@text = 'Invalid messaging address']");
	public By CONVERSATION_DETAILS_SCREEN_ADD_INVALID_PARTICIPANT_OK_BTN = By
			.xpath("//android.widget.Button[@text = 'OK']");
	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS IN CONTACT
	// SCREEN##############################################
	// ###########################################################################################################################
	public By conversationWindowsPhotofileiOS = By
			.xpath("//*[contains(@text,'.png')]");
	public By CONTACT_SCREEN_SEARCH_TXT = By
			.id("com.avaya.android.flare:id/unifiedContactsSearchEditText");
	public By CONTACT_SCREEN_LIST_CONTACT_ITEM = By.id("com.avaya.android.flare:id/contact_list_item");

	public By enterprise_result_by_name(String name) {
		return By.xpath("//*[@resource-id='com.avaya.android.flare:id/searchHeaderTitle' and contains(@text,'Enterprise')]/following-sibling::android.widget.RelativeLayout//android.widget.TextView[@resource-id='com.avaya.android.flare:id/contact_item_name' and @text='"+name+"']");
	}
	public By CONTACT_SCREEN_CONTACT_NAME(String contactName) {
		return By.xpath("//android.widget.TextView[@text = '" + contactName	+ "']");
	}

	public By CONTACT_LIST = By.id("com.avaya.android.flare:id/contacts_list_view");
	
	public By CONTACT_SCREEN_CONTACT_ITEM_FAVORITE = By
			.id("com.avaya.android.flare:id/contact_item_favorite");
	public By CONTACT_SCREEN_DETAILS_CONTACT_AMMMSG_BTN = By
			.id("com.avaya.android.flare:id/contact_details_im_address_icon");
	public By CONTACT_SCREEN_DETAILS_AMMMSG_BTN_NEW_CONVERSATION = By
			.xpath("//android.widget.TextView[@text = 'New Conversation']");

	public By ContactScreenDetailsAmmmsgExistedConversationLocator(
			String nameconversation) {
		return By.xpath("//android.widget.TextView[contains(@text, '"
				+ nameconversation + "')]");
	}

	public By CONTACT_SCREEN_DETAILS_CONTACT_CALL_VIDEO_BTN = By
			.id("com.avaya.android.flare:id/contact_details_phone_video_call_icon");
	public By CONTACT_SCREEN_DETAILS_CONTACT_CALL_AUDIO_BTN = By
			.id("com.avaya.android.flare:id/contact_details_phone_audio_call_icon");

	// android.widget.TextView[contains(@text,'dao')]

	public By CONTACT_SCREN_STRING_MUST_CONTAIN(String str) {
		return By.xpath("//android.widget.TextView[contains(@text,'" + str
				+ "')]");
	}

	// Long Press
	public By CONTACT_SCREEN_LIST_CONTACT_AMMMSG_BTN = By
			.id("com.avaya.android.flare:id/amm_message");
	public By CONTACT_SCREEN_LIST_CONTACT_CALLVIDEO_BTN = By
			.id("com.avaya.android.flare:id/call_video");
	public By CONTACT_SCREEN_LIST_CONTACT_CALLVOICE_BTN = By
			.id("com.avaya.android.flare:id/call_voice");

	// ###########################################################################################################################
	// ########################################LOCATOR OF ELEMENTS INCOMING CALL
	// SCREEN###########################################
	// ###########################################################################################################################

	public By INCOMING_CALL_SCREEN_ANSWER_BTN = By
			.id("com.avaya.android.flare:id/answer_audio_button");
	public By INCOMING_CALL_SCREEN_IGNORE_BTN = By
			.id("com.avaya.android.flare:id/ignore_button");
	public By INCOMING_CALL_SCREEN_ANSWER_VIDEO_BTN = By
			.id("com.avaya.android.flare:id/answer_video_button");
	// ###########################################################################################################################
	// ######################################LOCATOR OF ELEMENTS PHONE CALL MAIN
	// SCREEN###########################################
	// ###########################################################################################################################

	public By PHONE_CALL_MAIN_SCREEN_SHOW_ADVANCE_CONTROL_BTN = By
			.id("com.avaya.android.flare:id/show_advanced_controls");
	public By PHONE_CALL_MAIN_SCREEN_END_CALL_BTN = By
			.id("com.avaya.android.flare:id/active_call_end_call");
	public By PHONE_CALL_MAIN_SCREEN_VIDEO_CALL_BTN = By
			.id("com.avaya.android.flare:id/midcall_video");
	public By PHONE_CALL_MAIN_SCREEN_KEY_PAD_BTN = By
			.id("com.avaya.android.flare:id/midcall_keypad");
	public By PHONE_CALL_MAIN_SCREEN_MUTE_CALL_BTN = By
			.id("com.avaya.android.flare:id/midcall_mute");
	public By PHONE_CALL_MAIN_SCREEN_MORE_BTN = By
			.id("com.avaya.android.flare:id/show_advanced_controls");

	// ###########################################################################################################################
	// ######################################LOCATOR OF ELEMENTS ADVANCE CONTROL
	// PHONE CALL SCREEN################################
	// ###########################################################################################################################

	public By ADVANCE_CONTROL_PHONE_CALL_SCREEN_SEND_MESSAGE_BTN = By
			.id("com.avaya.android.flare:id/active_call_send_message");
	public By ADVANCE_CONTROL_PHONE_CALL_SCREEN_ADVCTR_TRANS_BTN = By
			.id("com.avaya.android.flare:id/activecall_advctrl_transfer");
	public By ADVANCE_CONTROL_PHONE_CALL_SCREEN_MID_HOLD_BTN = By
			.id("com.avaya.android.flare:id/midcall_hold");
	public By ADVANCE_CONTROL_PHONE_CALL_SCREEN_ADD_SOMEONE_BTN = By
			.id("com.avaya.android.flare:id/activecall_advctrl_add");
	public By ADVANCE_CONTROL_PHONE_CALL_SCREEN_CHOOSE_CONTACT_BTN = By
			.xpath("//*[@text='Choose a contact']");
	public By ADVANCE_CONTROL_PHONE_CALL_SCREEN_ENTER_NUMBER_BTN = By
			.xpath("//*[@text='Enter a number']");

	public By chooseContactListDetailScreenParticipantLocator(String user) {
		return By.xpath("//android.widget.TextView[contains(@text, '" + user
				+ "')]");
	}

	public By ADVANCE_CONTROL_PHONE_CALL_SCREEN_CHOOSE_CONTACT_LIST_SIP_ADDRESS(
			String phone) {
		return By.xpath("//android.widget.TextView[contains(@text, '" + phone
				+ "') and not(contains(@text, '@aam1.com'))]");
	}

	public By CONTACT_SCREEN_LIST_VIDEO_CALL_BANNER = By
			.id("com.avaya.android.flare:id/call_banner");

	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS VIEW PARTICIPANT LIST
	// SCONVERSATION CREEN##############################
	// ###########################################################################################################################
	public By ConversationParticipantListDetailScreenParticipantLocator(
			String user) {
		return By.xpath("//android.widget.TextView[contains(@text, '" + user
				+ "')]");
	}

	public By CONVERSATION_DETAILS_SCREEN_PARTICIPANT_LIST_TITLE_TXT = By
			.id("com.avaya.android.flare:id/messaging_participant_list_title");
	public By CONVERSATION_DETAILS_SCREEN_PARTICIPANT_BACK_BTN = By
			.id("com.avaya.android.flare:id/btn_back");

	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS TOP OF MIND
	// SCREEN#####################################################
	// ###########################################################################################################################

	public By TOP_OF_MIND_SCREEN_CONVERSATION_LIST_TXT = By
			.id("com.avaya.android.flare:id/layout_item_content");
	public By TOP_OF_MIND_TXT = By
			.id("com.avaya.android.flare:id/tom_title_view");
	public By TOP_OF_MIND_TAB = By
			.id("com.avaya.android.flare:id/tom_title_view");

	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS TOP OF MIND
	// SCREEN#####################################################
	// ###########################################################################################################################

	public By HISTORY_DETAILS_SCREEN_TITLE = By
			.xpath("//*[@text = 'History Details']");
	public By HISTORY_DETAILS_SCREEN_BACK_BUTTON = By
			.className("android.widget.ImageButton");
	public By HISTORY_DETAILS_SCREEN_HISTORY_TITLE = By
			.xpath("//*[@text = 'History']");
	public By HISTORY_DETAILS_SCREEN_DELETE_HISTORY_TITLE = By
			.xpath("//*[@text = 'Delete All History']");

	public By HISTORY_DETAILS_SCREEN_DELETE_HISTORY_CONFIRM_BTN = By
			.id("android:id/button1");

	public By CALL_HISTORY_CONTACT_NAME(String No) {
		return By
				.xpath("//android.widget.RelativeLayout[@resource-id='com.avaya.android.flare:id/recents_list_item' and @index ='0']/android.widget.TextView[@resource-id='com.avaya.android.flare:id/recentsContactName']");
		// return
		// By.xpath("//*[@I=id='com.avaya.android.flare:id/recents_list_item' and @index='"+No+"']//*[@id='com.avaya.android.flare:id/recentsContactName']");
	}

	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS AADS AUTO LOGIN
	// SCREEN#################################################
	// ###########################################################################################################################

	public By FIRST_SCREEN_SETTING_WEB_ADDRESS_TXT = By
			.id("com.avaya.android.flare:id/auto_config_address");
	public By FIRST_SCREEN_SETTING_USE_WEB_NEXT_BTN = By
			.id("com.avaya.android.flare:id/connect_button");
	public By AADS_LOGIN_SCREEN_SETTING_USER_TXT = By
			.id("com.avaya.android.flare:id/service_username");
	public By AADS_LOGIN_SCREEN_SETTING_PWD_TXT = By
			.id("com.avaya.android.flare:id/service_password");
	public By AADS_LOGIN_SCREEN_ALLOW_TXT = By
			.id("com.android.packageinstaller:id/permission_allow_button");
	public By AADS_LOGIN_SCREEN_OK_BTN = By.id("android:id/button1");
	public By AADS_LOGIN_SCREEN_ACCEPT_BTN = By
			.id("com.avaya.android.flare:id/acceptBtn");
	public By AADS_LOGIN_SCREEN_SKIP_BTN = By
			.id("com.avaya.android.flare:id/skip_button");
	public By AADS_LOGIN_SCREEN_SKIP_LEFTBTN = By
			.id("com.avaya.android.flare:id/leftBtn");

	// /public By AADS_LOGIN_SCREEN_ACCEPT_COMFIRM_BTN =
	// By.id("com.avaya.android.flare:id/emergency_number_confirmation_button");
	// locator for Equinox 3.3
	// public By AADS_LOGIN_SCREEN_ACCEPT_COMFIRM_BTN =
	// By.id("com.avaya.android.flare:id/emergency_number_confirmation_button");
	// locator for Equinox 3.4

	public By AADS_LOGIN_SCREEN_ACCEPT_COMFIRM_BTN = By
			.id("android:id/button1");

	// public By AADS_LOGIN_SCREEN_ACCEPT_COMFIRM_BTN =
	// By.id("android:id/button1");

	public By AADS_LOGIN_SCREEN_SKIP_TUTORIAL_BTN = By
			.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.Button[1]");

	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS CONTACT DETAIL
	// SCREEN##################################################
	// ###########################################################################################################################

	public By CONTACT_DETAIL_SCREEN_FAVORITE_CONTACT_BTN = By
			.id("com.avaya.android.flare:id/contact_favorite");
	public By CONTACT_DETAIL_SCREEN_ADD_CONTACT_BTN = By
			.xpath("//android.widget.TextView[@text = 'Add to Contacts']");
	public By CONTACT_DETAIL_SCREEN_REMOVE_CONTACT_BTN = By
			.xpath("//android.widget.TextView[@text = 'Remove Contact']");
	public By CONTACT_DETAIL_SCREEN_REMOVE_CONTACT_BTN1 = By
			.name("Remove Contact");
	public By CONTACT_DETAIL_SCREEN_NAVIGATE_UP_BTN = By
			.xpath("//android.widget.ImageButton[@content-desc = 'Navigate up']");
	public By CONTACT_DETAIL_SCREEN_SEARCH_CANCEL_BTN = By
			.id("com.avaya.android.flare:id/unifiedContactsSearchCancel");

	public By contactDetailScreenUserNameLocator(String user) {
		return By.xpath("//android.widget.TextView[@text = '" + user + "']");
	}
	
	public By CONTACT_TAB_USER_NAME(String user) {
		return By.xpath("//android.widget.TextView[@text = '" + user + "']");
	}
	
	public By CONTACT_TAB_CONTACT_VIEW_OPTON_BUTTON = By
			.className("android.view.View");
	public By CONTACT_TAB_CONTACT_EQUINOX_CONTACTS_BUTTON = By
			.xpath("//android.widget.TextView[@text = 'Equinox Contacts']");

	public By CONTACT_TAB_CONTACTS_EXIST_BUTTON = By.id("android:id/button2");
	public By SETTING_DONE = By.id("com.avaya.android.flare:id/toolbar_done");
	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS CONTACT WINDOWS
	// DETAIL SCREEN##########################################
	// ###########################################################################################################################

	public By CONTACT_TAB_SCREEN_ADD_CONTACT_BTN = By
			.id("com.avaya.android.flare:id/contactsActionButton");
	public By CONTACT_TAB_SCREEN_ADD_CONTACT_CONTACT_BTN = By
			.xpath("//android.widget.TextView[@text = 'New Contact']");
	public By CONTACT_TAB_SCREEN_REMOVE_CONTACT_BTN = By
			.xpath("//android.widget.TextView[@text = 'Remove Contact']");
	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS ADD CONTACT DETAIL
	// SCREEN##########################################
	// ###########################################################################################################################

	public By ADD_CONTACT_SCREEN_FIRST_NAME_TXT = By
			.xpath("//android.widget.EditText[@text = 'First Name']");
	public By ADD_CONTACT_SCREEN_LAST_NAME_TXT = By
			.xpath("//android.widget.EditText[@text = 'Last Name']");
	public By ADD_CONTACT_SCREEN_NUMBER_PHONE_TXT = By
			.xpath("//android.widget.EditText[@text = 'Number is required']");
	public By ADD_CONTACT_SCREEN_ADDRESS_TXT = By
			.xpath("//android.widget.EditText[@text = 'Address']");
	public By ADD_CONTACT_SCREEN_EMAIL_TXT_2 = By.xpath("//android.widget.EditText[@text = 'Address is required']"); //Before input number

	public By ADD_CONTACT_SCREEN_EMAIL_TXT = By.xpath("//android.widget.LinearLayout[@resource-id='com.avaya.android.flare:id/linear_layout_emails']//android.widget.EditText");
	
	public By ADD_CONTACT_SCREEN_DONE_BTN = By
			.id("com.avaya.android.flare:id/button_done");
	public By ADD_CONTACT_SCREEN_CANCEL_BTN = By
			.id("com.avaya.android.flare:id/button_cancel");
	public By ADD_CONTACT_SCREEN_NUMBER_PHONE_TITLE = By
			.xpath("//android.widget.TextView[@text = 'Add Phone Number']");

	// ###########################################################################################################################
	// ################################LOCATOR OF ELEMENTS SIGN OUT AND SIGN IN
	// ##########################################
	// ###########################################################################################################################

	public By PROFILE_AVATAR = By
			.id("com.avaya.android.flare:id/profile_avatar");
	public By SIGN_OUT_BTN = By.id("com.avaya.android.flare:id/signout");
	public By PREFERENCES = By.id("com.avaya.android.flare:id/preferences");
	public By LOCAL_USER_AVATAR = By
			.id("com.avaya.android.flare:id/local_user_avatar");
	public By SIGN_IN_BTN = By.id("com.avaya.android.flare:id/btnSignIn");
	public By CONVERSATION_DETAILS_SCREEN_TAKE_PHOTO_PRESS_BTN_S6 = By
			.id("com.lge.camera:id/shutter_bottom_comp_type");

	// CALL LOCATOR
	public By MAIN_SCREEN_DIALPAD = By
			.id("com.avaya.android.flare:id/homeDialpadButton");
	public By DIALPAD_INPUT_NUMBER_TXT = By
			.id("com.avaya.android.flare:id/inputnumbertext");
	public By DIALPAD_CALL_BTN = By
			.id("com.avaya.android.flare:id/dialpad_call");
	public By INCOMING_CALL_NAME = By
			.id("com.avaya.android.flare:id/call_label");
	// public By INCOMING_CALL_NAME_BEFORE_ACCEPT =
	// By.id("com.avaya.android.flare:id/incoming_call_remote_party_label");
	// for ACA 3.3
	public By INCOMING_CALL_NAME_BEFORE_ACCEPT = By
			.id("com.avaya.android.flare:id/incoming_call_remote_party_label");
	public By HISTORY_CALLER_NAME = By.id("com.avaya.android.flare:id/tvName");

	// EDIT CONTACT LOCATOR
	public By CONTACT_SCREEN_EDIT_CONTACT_BTN = By
			.id("com.avaya.android.flare:id/menu_edit");
	public By EDIT_CONTACT_SCREEN_FIRSTNAME_TXT = By
			.id("com.avaya.android.flare:id/edit_text_first_name");
	public By EDIT_CONTACT_SCREEN_LASTNAME_TXT = By
			.id("com.avaya.android.flare:id/edit_text_last_name");
	public By EDIT_CONTACT_SCREEN_COMPANY_TXT = By
			.id("com.avaya.android.flare:id/edit_text_company");
	public By EDIT_CONTACT_SCREEN_BUILDING_TXT = By
			.id("com.avaya.android.flare:id/edit_text_building");
	public By EDIT_CONTACT_SCREEN_ADDRESS_TXT = By
			.id("com.avaya.android.flare:id/edit_text_address");
	public By EDIT_CONTACT_SCREEN_EMAIL_TXT = By
			.xpath("//android.widget.EditText[contains(@text,'com.avaya.android.flare:id/linear_layout_emails')]//android.widget.LinearLayout");

	public By EDIT_CONTACT_SCREEN_PHONE_TXT(String phone) {
		return By.xpath("//android.widget.EditText[contains(@text,'" + phone
				+ "')]");
	}

	/**
	 * @author HuyD fieldname: first_name, last_name, company, buiding, address
	 * 
	 * 
	 */

	public By EDIT_CONTACT_SCREEN_TXT_FIELD(String fieldname) {
		return By.id("com.avaya.android.flare:id/edit_text_" + fieldname);
	}

	public By EDIT_FIRST_NAME_TXT_FIELD = By
			.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.EditText");
	public By EDIT_COMPANY_TXT_FIELD = By
			.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.EditText");
	public By EDIT_CONTACT_SCREEN_DONE_BTN1 = By
			.xpath("//android.widget.Button[@text='DONE']");

	public By EDIT_CONTACT_SCREEN_DONE_BTN = By
			.xpath("//android.widget.Button[@text= 'DONE']");// 3.2 DONE 3.3
																// Done

	public By TITLE_BTN = By
			.id("com.avaya.android.flare:id/recents_filter_header_title");

	public By SEARCH_CONTACT_LOCAL_CONTACT_TITLE_BAR = By
			.xpath("//*[@resource-id='com.avaya.android.flare:id/searchHeaderTitle' and contains(@text,'Contacts')]");
	public By SEARCH_CONTACT_ENTERPRISE_CONTACT_TITLE_BAR = By
			.xpath("//*[@resource-id='com.avaya.android.flare:id/searchHeaderTitle' and contains(@text,'Enterprise')]");

	/*
	 * public By local_result_by_order(String order){ return By.xpath(
	 * "//*[@resource-id='com.avaya.android.flare:id/searchHeaderTitle' and contains(@text,'Contacts')]"
	 * ); }
	 */
	/*
	 * public By enterprise_result_by_order(String order){ return By.xpath(
	 * "//*[@resource-id='com.avaya.android.flare:id/searchHeaderTitle' and contains(@text,'Contacts')]/following-sibling::android.widget.RelativeLayout["
	 * +
	 * order+"]//*[@resource-id='com.avaya.android.flare:id/contact_item_name']"
	 * ); }
	 */

	public By enterprise_result_by_order(String order) {
		return By
				.xpath("//*[@resource-id='com.avaya.android.flare:id/searchHeaderTitle' and contains(@text,'Enterprise')]/following-sibling::android.widget.RelativeLayout["+ order+ "]//*[@resource-id='com.avaya.android.flare:id/contact_item_name']");
	}

	public By local_result_by_order(String order) {
		return By
				.xpath("//*[@resource-id='com.avaya.android.flare:id/searchHeaderTitle' and contains(@text,'Contacts')]/following-sibling::android.widget.RelativeLayout["
						+ order
						+ "]//*[@resource-id='com.avaya.android.flare:id/contact_item_name']");
	}

	public By CONTACT_ALREADY_EXISTED = By.id("android:id/message");
	public By CONTACT_ALREADY_EXISTS_BTN_OK = By
			.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");
	public By CONTACT_DETAIL_PHONENUMBER = By
			.id("com.avaya.android.flare:id/linear_layout_phone_numbers_list");
	public By CONTACT_DETAIL_CONTACTNAME = By
			.id("com.avaya.android.flare:id/contact_name");

	// ////////////////////////////////////LOCATION MANUALLY LOGIN
	// ///////////////////////////
	// public By SETTING_SCREEN_SERVICES_TAB = By.linkText(linkText);
	public By SETTING_SCREEN_SERVICES_TAB = By.name("Services");
	public By SETTING_SCREEN_SERVICES_TAB_MULTIMEDIA_DETAIL = By
			.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.RelativeLayout");
	public By SETTING_SCREEN_ALLOW = By
			.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[7]/android.widget.RelativeLayout");
	public By CONTACT_DETAILS_COMPANY = By.id("com.avaya.android.flare:id/contact_company");
	// public By CONTACT_DETAILS_COMPANY1 =
	// By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
	// public By CONTACT_DETAILS_PHONE_NUMBER =
	// By.id("com.avaya.android.flare:id/contact_details_phone_number");
	// public By =
	// By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]);

	public By NAV_UP_BTN = By
			.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	public By CONTACTS_DETAIL_PREFERENCES = By
			.id("com.avaya.android.flare:id/my_presence");

	// public By CONTACTS_DETAIL_PREFERENCES_T (String status) { return
	// By.xpath("/hierarchy/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout["+status+"]/android.widget.CheckedTextView [@checked='true']");}
	// public By CONTACTS_DETAIL_PREFERENCES_F (String status) { return
	// By.xpath("/hierarchy/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout["+status+"]/android.widget.CheckedTextView [@checked='false']");}
	// ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.CheckedTextView
	// [@checked='false']
	public By CONTACTS_DETAIL_PREFERENCES_T(String status) {
		return By.xpath("//android.widget.CheckedTextView[@text='" + status
				+ "' and @checked='true']");
	}

	public By CONTACTS_DETAIL_PREFERENCES_F(String status) {
		return By.xpath("//android.widget.CheckedTextView[@text='" + status
				+ "' and @checked='false']");
	}

	public By CONTACTS_DETAIL_CALL = By
			.id("com.avaya.android.flare:id/contact_details_phone_audio_call_icon");
	public By CONTACTS_DETAIL_END_CALL = By
			.id("com.avaya.android.flare:id/active_call_end_call");
	public By CONTACTS_DETAIL_STATUS_SUMMARY = By
			.id("com.avaya.android.flare:id/contact_summary");
}
