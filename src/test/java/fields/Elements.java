package fields;

public class Elements {
    // block按钮
    public static final String block_by = "XPATH";
    public static final String block = "//*[@id=\"blocked-user-list\"]/form/div/div/span/button";

    // 黑名单
    public static final String blockUser_by = "XPATH";
    public static final String blockUser = "//*[@id=\"js-pjax-container\"]/div/div[1]/nav[1]/a[9]";

    // save profile
    public static final String saveProfile_by = "XPATH";
    public static final String saveProfile = "//*[@id=\"js-pjax-container\"]/div/div[1]/form/div[6]/button[1]";

    // Edit Profile
    public static final String editProfile_by = "XPATH";
    public static final String editProfile = "//*[@id=\"js-pjax-container\"]/div/div[1]/div[6]/button";

    // 查看hello-world仓库
    public static final String helloWorldRepository_by = "XPATH";
    public static final String helloWorldRepository = "/html/body/div[4]/div/aside[1]/div[2]/div/div/ul/li[1]/div/a/span[2]";

    // SSHKEY
    public static final String key_pub_by = "XPATH";
    public static final String key_pub = "//*[@id=\"public_key_key\"]";

    // Title
    public static final String keyTitle_by = "XPATH";
    public static final String keyTitle = "//*[@id=\"public_key_title\"]";

    // 点击addkey
    public static final String addKey_by = "XPATH";
    public static final String addKey = "//*[@id=\"new_key\"]/p/button";

    // 点击NEW SSH KEYS
    public static final String createSSHKey_by = "XPATH";
    public static final String createSSHKey = "//*[@id=\"js-pjax-container\"]/div/div[2]/div[1]/div[2]/a";

    // 点击SSH-GPG-keys
    public static final String ssh_GPG_by = "XPATH";
    public static final String ssh_GPG = "//*[@id=\"js-pjax-container\"]/div/div[1]/nav[1]/a[6]";

    // 点击settings
    public static final String settings_by = "XPATH";
    public static final String settings = "/html/body/div[1]/header/div[8]/details/details-menu/a[7]";

    // 点击your profile
    public static final String myProfile_by = "XPATH";
    public static final String myProfile = "/html/body/div[1]/header/div[8]/details/details-menu/a[1]";

    // createNewRepository
    public static final String createNewRepository_by = "XPATH";
    public static final String createNewRepository = "//*[@id=\"new_repository\"]/div[3]/button";

    // 仓库名称
    public static final String repositoryName_by = "XPATH";
    public static final String repositoryName = "//*[@id=\"repository_name\"]";

    // 新建仓库
    public static final String createRepository_by = "XPATH";
    public static final String createRepository = "/html/body/div[1]/header/div[7]/details/details-menu/a[1]";

    // “+”图标
    public static final String menu_by = "XPATH";
    public static final String menu = "/html/body/div[1]/header/div[7]/details/summary/svg/path";

    // signout
    public static final String signOut_by = "XPATH";
    public static final String signOut = "/html/body/div[1]/header/div[8]/details/details-menu/form/button";

    // 头像
    public static final String headImage_by = "XPATH";
    public static final String headImage = "/html/body/div[1]/header/div[8]/details/summary/img";

    // 密码
    public static final String passwd_by = "XPATH";
    public static final String passwd = "//*[@id=\"password\"]";

    // 账号
    public static final String account_by = "XPATH";
    public static final String account = "//*[@id=\"login_field\"]";

    // 登录失败
    public static final String loginFailedMessage_by = "XPATH";
    public static final String loginFailedMessage = "//*[@id=\"js-flash-container\"]/div/div";

    // login
    public static final String login_by = "XPATH";
    public static final String login = "//*[@id=\"login\"]/form/div[3]/input[4]";

    // Sign In
    public static final String signIn_by = "XPATH";
    public static final String signIn = "/html/body/div[1]/header/div/div[2]/div[2]/a[1]";

}
