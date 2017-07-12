package zovlzhongguanhua.demo.jenkins;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        listView = (ListView) findViewById(R.id.listView);
        Adapter adapter = new Adapter();
        listView.setAdapter(adapter);
        for (int i = 0; i < 50; i++) {
            data.add(i + "");
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this, "点击了条目：" + position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.notifyDataSetChanged();
    }

    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size() == 0 ? 0 : data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.size() == 0 ? null : data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getBaseContext()).inflate(R.layout.item_second, null);
                viewHolder = new ViewHolder();
                viewHolder.mTextView1 = (TextView) convertView.findViewById(R.id.item_tv1);
                viewHolder.mTextView2 = (TextView) convertView.findViewById(R.id.item_tv2);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.mTextView1.setText("左边");
            viewHolder.mTextView2.setText(data.get(position) + "");
            viewHolder.mTextView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SecondActivity.this, "点击了条目内的：" + position + "的mTextView1", Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.mTextView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SecondActivity.this, "点击了条目内的：" + position + "的mTextView2", Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
    }

    class ViewHolder {
        TextView mTextView1, mTextView2;
    }
}
