package com.example.hp.railss;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.railss.api.Model;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.RepoHolder> {
        List<Model> gitHubRepoList;

public DetailAdapter(List<Model> gitHubReposList) {
        this.gitHubRepoList = gitHubReposList;
        }

@NonNull
@Override
public RepoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RepoHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull RepoHolder holder, int position) {
        holder.textView.setText(gitHubRepoList.get(position).getDoj());
       // holder.textView.setText((CharSequence) gitHubRepoList.get(position).getFrom_station());
        //holder.textView.setText((CharSequence) gitHubRepoList.get(position).getTo_station());
        //holder.textView.setText(gitHubRepoList.get(position).getTotal_passengers());
        }

@Override
public int getItemCount() {
        return gitHubRepoList.size();
        }

public class RepoHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public RepoHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.textView);
    }
}
}