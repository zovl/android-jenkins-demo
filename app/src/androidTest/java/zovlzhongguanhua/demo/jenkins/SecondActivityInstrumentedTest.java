package zovlzhongguanhua.demo.jenkins;

import android.content.ComponentName;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.instanceOf;

@RunWith(AndroidJUnit4.class)
public class SecondActivityInstrumentedTest {

    @Rule
    public ActivityTestRule mActivity = new ActivityTestRule(MainActivity.class, false, true);

    @Test
    public void testWrite() {Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        //注意ComponentName的参数  包名 包名+类名（全路径）  不然会crash  提示找不到对应的类
        ComponentName cn = new ComponentName("com.androidtest", "com.androidtest.MainActivity");
        intent.setComponent(cn);
        //启动第三方的app界面
        mActivity.getActivity().startActivity(intent);
        onData(instanceOf(String.class))            //item的数据类型
                .inAdapterView(withId(R.id.listView))    //根据listView的id 找到adapter
                .atPosition(11)                     //找到listView的某个item
                .perform(click());

        onData(instanceOf(String.class))            //item的数据类型
                .inAdapterView(withId(R.id.listView))    //根据listView的id 找到adapter
                .atPosition(35)                     //找到listView的某个item
                .onChildView(withId(R.id.item_tv2)) //点击条目内子控件
                .perform(click());
    }
}
