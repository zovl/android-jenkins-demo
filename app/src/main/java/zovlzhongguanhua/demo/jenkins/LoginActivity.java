package zovlzhongguanhua.demo.jenkins;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Context context;
    private EditText usernameEdt, passwordEdt;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;

        usernameEdt = (EditText) findViewById(R.id.usernameEdt);
        passwordEdt = (EditText) findViewById(R.id.passwordEdt);
        submitBtn = (Button) findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdt.getText().toString();
                String password = passwordEdt.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(context, "用户名不能为空！", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(context, "密码不能为空！", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!"admin".equals(username) ||
                        !"admin123456".equals(password)) {
                    Toast.makeText(context, "账号密码不正确！", Toast.LENGTH_LONG).show();
                    return;
                }
                Toast.makeText(context, "登录成功！", Toast.LENGTH_LONG).show();
                startActivity(new Intent(context, MainActivity.class));
            }
        });
    }
}
