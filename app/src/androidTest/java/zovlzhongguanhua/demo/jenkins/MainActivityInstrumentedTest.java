package zovlzhongguanhua.demo.jenkins;

import android.content.ComponentName;
import android.content.Intent;
import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityTestRule mActivity = new ActivityTestRule(MainActivity.class, false, true);

    @Test
    public void testWrite() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        //注意ComponentName的参数  包名 包名+类名（全路径）  不然会crash  提示找不到对应的类
        ComponentName cn = new ComponentName("zovlzhongguanhua.demo.jenkins", "zovlzhongguanhua.demo.jenkins.MainActivity");
        intent.setComponent(cn);
        //启动第三方的app界面
        mActivity.getActivity().startActivity(intent);
        //点击返回，退出当前的activity返回到之前的activity
        SystemClock.sleep(1 * 1000);
        //输入长江
        onView(withId(R.id.username))
                .perform(replaceText("长江"), closeSoftKeyboard());
        //暂停1s
        SystemClock.sleep(1 * 1000);
        //替换长江-->黄河
        onView(withId(R.id.username))
                .perform(clearText(), replaceText("黄河"), closeSoftKeyboard());
        SystemClock.sleep(1 * 1000);
        //输入密码
        onView(withId(R.id.password))
                .perform(replaceText("123456"), closeSoftKeyboard());
        SystemClock.sleep(1 * 1000);
        //点击登录
        onView(withId(R.id.login))
                .perform(click());
        SystemClock.sleep(1 * 1000);
    }
}
