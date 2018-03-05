package com.example.scrollhidesticky;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.scrollhidesticky.data.Person;
import com.example.scrollhidesticky.data.PeopleRepo;

import java.util.List;

/**
 * hide and show header using CoordinatorLayout AppBarLayout and RecyclerView
 */
public class MainFragment extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        final List<Person> people = PeopleRepo.getPeopleSorted();
        recyclerView.setAdapter(new PersonAdapter(people, R.layout.list_item));

        RecyclerSectionItemDecoration sectionItemDecoration =
                new RecyclerSectionItemDecoration(getResources().getDimensionPixelSize(R.dimen.recycler_section_header_height),
                        true,
                        getSectionCallback(people));
        recyclerView.addItemDecoration(sectionItemDecoration);


        return view;
    }

    private RecyclerSectionItemDecoration.SectionCallback getSectionCallback(final List<Person> people) {
        return new RecyclerSectionItemDecoration.SectionCallback() {
            @Override
            public boolean isSection(int position) {
                return position == 0
                        || people.get(position)
                        .getLastName()
                        .charAt(0) != people.get(position - 1)
                        .getLastName()
                        .charAt(0);
            }

            @Override
            public CharSequence getSectionHeader(int position) {
                return people.get(position)
                        .getLastName()
                        .subSequence(0,
                                1);
            }
        };
    }



}