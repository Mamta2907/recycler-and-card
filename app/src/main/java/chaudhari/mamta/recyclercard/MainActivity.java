package chaudhari.mamta.recyclercard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ExampleItem> exampleList;
    private Button buttonAdd,buttonDelete;
    private EditText editTextAdd,editTextDelete;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateFakeData();
        recyclerViewConfig();

        buttonAdd = findViewById(R.id.buttonadd);
        buttonDelete = findViewById(R.id.buttondelete);
        editTextAdd = findViewById(R.id.edittextadd);
        editTextDelete = findViewById(R.id.edittextdelete);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextAdd.getText().toString());
                addCard(position);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextDelete.getText().toString());
                deleteCard(position);
            }
        });

    }

    private void recyclerViewConfig() {
        //config for RV
        recyclerView = findViewById(R.id.recyclerView);
        //perfprmance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        adapter = new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void generateFakeData(){
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.airpod,"Clicked by mamta 1"));
        exampleList.add(new ExampleItem(R.drawable.head,"Clicked by mamta 2"));
        exampleList.add(new ExampleItem(R.drawable.cd,"Clicked by mamta 3"));
        exampleList.add(new ExampleItem(R.drawable.headphone,"Clicked by mamta 4"));
        exampleList.add(new ExampleItem(R.drawable.radio,"Clicked by mamta 5"));
        exampleList.add(new ExampleItem(R.drawable.head,"Clicked by mamta 6"));
    }

    public void addCard(int position){
        exampleList.add(position,new ExampleItem(R.drawable.headphone,"New card added..."));
        //adapter.notifyDataSetChanged();
        adapter.notifyItemInserted(position);
    }

    public void deleteCard(int position){
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}