package com.example.scrollhidesticky;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.scrollhidesticky.data.Person;

import java.util.List;


public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private final List<Person> people;
    private final int          rowLayout;

    public PersonAdapter(List<Person> people, @LayoutRes int rowLayout) {
        this.people = people;
        this.rowLayout = rowLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Person person = people.get(position);
        holder.fullName.setText(person.getFullName());
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fullName;

        public ViewHolder(View view) {
            super(view);
            fullName = (TextView) view.findViewById(R.id.tv_text);
        }
    }
}
