package com.example.scrollhidesticky;

import android.content.Context;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * DrawerLayout
 * Fragment in a FrameLayout
 * CoordinatorLayout AppBarLayout
 * RecyclerView
 *
 * With ListView, the show and hide header on scroll won't work with CoordinatorLayout AppBarLayout
 * With ListView, the show and hide header on scroll only works if set listView.setNestedScrollingEnabled(true); for Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
 * With ListView, the show and hide header on scroll can be achieved using the header trick in ScrollingActivity3
 */
public class MainActivity extends AppCompatActivity {

    protected DrawerLayout drawerLayout;
    RelativeLayout leftDrawerView;
    protected ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment scrollingActivity4Fragment = new MainFragment();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, scrollingActivity4Fragment, "tag_scrollingActivity4Fragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);


        if (drawerToggle == null) {
            drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_menu, R.string.drawer_open, R.string.drawer_close) {
                public void onDrawerClosed(View view) {
                }

                public void onDrawerOpened(View drawerView) {

                }

                public void onDrawerSlide (View drawerView, float slideOffset) {
                }

                public void onDrawerStateChanged(int newState) {

                }

            };
            drawerLayout.setDrawerListener(drawerToggle);
        }

        drawerToggle.syncState();

        leftDrawerView = (RelativeLayout) findViewById(R.id.left_drawer);
        ListView rvNumbers = (ListView) findViewById(R.id.list);

        String [] numbers = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(this, R.layout.list_item, numbers);
        rvNumbers.setAdapter(itemArrayAdapter);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class ItemArrayAdapter extends ArrayAdapter<String> {
        String[] itemList;
        private int listItemLayout;
        public ItemArrayAdapter(Context context, int layoutId, String[] itemList) {
            super(context, layoutId, itemList);
            listItemLayout = layoutId;
            this.itemList = itemList;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int pos = position;
            String item = getItem(pos);

            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(listItemLayout, parent, false);
                viewHolder.item = (TextView) convertView.findViewById(R.id.tv_text);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.item.setText(item);
            return convertView;
        }
        class ViewHolder {
            TextView item;
        }
    }
}
