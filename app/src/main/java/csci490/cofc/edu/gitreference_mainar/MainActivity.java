package csci490.cofc.edu.gitreference_mainar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    String jsonStr;
    InputStream inputStream;
    ArrayList<GitReference> arrayList;
    GitReferenceAdapter gitReferenceAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = this.findViewById(R.id.list_view);
        try{
            inputStream = getApplicationContext().getAssets().open("gitReference.json");
            jsonStr = JsonUtils.parseJsonToString(inputStream);
            arrayList = JsonUtils.populateGitReferences(jsonStr);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        gitReferenceAdapter = new GitReferenceAdapter(this, arrayList);
        listView.setAdapter(gitReferenceAdapter);



    }

}
