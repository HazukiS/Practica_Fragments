package edu.tecii.android.practica_fragments;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by hazuk on 31/10/2016.
 */
public class FragmentBlue extends Fragment {
    MainActivity main;
    Context context = null;
    String message = "";

    private String items[] = {"Text-on-Line","Text-on-line-01","Text-on-Line-02","Text-on-Line-03",
            "Text-on-Line-04","Text-on-Line-05","Text-on-Line-06",
            "Text-on-Line-07","Text-on-Line-08","Text-on-Line-09",
            "Text-on-Line-10",};

    public static FragmentBlue newInstance(String strArg){
        FragmentBlue fragment = new FragmentBlue();
        Bundle args = new Bundle();
        args.putString("strArg1",strArg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try{
            context = getActivity();
            main = (MainActivity)getActivity();
        }catch(IllegalStateException e){
            throw new IllegalStateException(
                    "MainActivity must implement callbacks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        LinearLayout layout_blue = (LinearLayout)inflater.inflate(R.layout.blue,null);
        final TextView txtBlue = (TextView)layout_blue.findViewById(R.id.textView1Blue);
        ListView listView = (ListView)layout_blue.findViewById(R.id.listView1Blue);
        listView.setBackgroundColor(Color.parseColor("#ffccddff"));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
        listView.setSelection(0);
        listView.smoothScrollToPosition(0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                main.onMsgFromFragToMain("BLUE-FRAG", "Blue selected row=" + position);
                txtBlue.setText("Blue selected row=" + position);
            }
        });
        return layout_blue;
    }
}
