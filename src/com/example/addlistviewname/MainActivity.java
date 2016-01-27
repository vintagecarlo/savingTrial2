package com.example.addlistviewname;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements OnClickListener {
    EditText txtName;
    ImageButton btnAdd;
    ListView lv;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtName = (EditText) this.findViewById(R.id.editText1);
        this.btnAdd = (ImageButton) this.findViewById(R.id.imageButton1);
        this.lv = (ListView) this.findViewById(R.id.listView1);
        
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        this.lv.setAdapter(adapter);
        this.btnAdd.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String name = this.txtName.getText().toString();
		if(!name.equals("")){
			list.add(name);
			adapter.notifyDataSetChanged();
			this.txtName.setText("");
			this.txtName.requestFocus();
		}else{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Error");
				builder.setMessage("Fill the name field");
				builder.setNeutralButton("ok",null);
		    AlertDialog dialog = builder.create();
		    dialog.show();
		}
		
	}
}
