package zovlzhongguanhua.demo.jenkins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private TextView login;
    private TextView show, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        login = (TextView) findViewById(R.id.login);
        show = (TextView) findViewById(R.id.show);
        title = (TextView) findViewById(R.id.title);

        title.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    private int count;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String s = username.getText().toString();
                String s1 = password.getText().toString();
                show.setText("账号：" + s + "    密码: " + s1);
                break;
            case R.id.title:
                count++;
                startActivity(new Intent(this, SecondActivity.class));
                break;
            default:
                break;
        }
    }
}
