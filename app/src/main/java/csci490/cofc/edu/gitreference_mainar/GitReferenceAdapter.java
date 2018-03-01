package csci490.cofc.edu.gitreference_mainar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by smainar on 2/27/2018.
 */

public class GitReferenceAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<GitReference> gitReferenceArrayList;

    public GitReferenceAdapter(Context context, ArrayList<GitReference> gitReferenceArrayList){
        mContext = context;
        this.gitReferenceArrayList = gitReferenceArrayList;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return gitReferenceArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return gitReferenceArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.git_ref_view, parent, false);
        TextView commandView = rowView.findViewById(R.id.command);
        TextView exampleView = rowView.findViewById(R.id.example);
        TextView explanationView = rowView.findViewById(R.id.explanation);
        TextView sectionView = rowView.findViewById(R.id.section);
        GitReference gitReference = (GitReference) getItem(position);

        commandView.setText(gitReference.getCommand());
        explanationView.setText(gitReference.getExplanation());
        exampleView.setText(gitReference.getExample());
        sectionView.setText(gitReference.getSection());


        return rowView;
    }
}
