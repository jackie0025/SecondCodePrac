package studio.jackie.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is "+getTaskId());

        setContentView(R.layout.first_layout);
        Button button=(Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent=new Intent(FirstActivity.this,SecondActivity.class);

                //Intent intent=new Intent("jackie.studio.activitytest.ACTION_START");
                //intent.addCategory("android.intent.category.MY_CATEGORY");

                //Intent intent=new Intent(Intent.ACTION_VIEW);
               // intent.setData(Uri.parse("http://www.baidu.com"));
                /*Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/
                /*
                String data="Hello Android";
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("mydata",data);
                startActivity(intent);
                */
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);//请求码设置为1，唯一就行
                //Intent intent=new Intent(FirstActivity.this,FirstActivity.class);
               // startActivity(intent);



               // Toast.makeText(FirstActivity.this,"You clicked Button",
                //        Toast.LENGTH_SHORT).show();
               // Log.d("jzDebug",FirstActivity.this.toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Log.d("jzDebug",returnedData);
                }
                break;
            default:
                Log.d("jzDebug","sth wrong");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
