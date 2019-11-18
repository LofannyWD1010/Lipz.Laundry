package com.example.lipzlaundry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<String> mGroups;
    private HashMap<String, List<String>> mChilds;

    public ExpandListAdapter(Context context, List<String> groups,
                             HashMap<String, List<String>> childs) {
        mContext = context;
        mGroups = groups;
        mChilds = childs;
    }

    /**
     * get size list group
     */
    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    /**
     * get size current list child
     */
    @Override
    public int getChildrenCount(int groupPosition) {
        return mChilds.get(mGroups.get(groupPosition)).size();
    }

    /**
     * get object group
     */
    @Override
    public Object getGroup(int groupPosition) {
        return mGroups.get(groupPosition);
    }

    /**
     * get object child
     */
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mChilds.get(mGroups.get(groupPosition)).get(childPosition);
    }

    /**
     * get current group id
     */
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    /**
     * get current child id
     */
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String groupText = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_layout, null);
        }

        TextView textView = (TextView) convertView
                .findViewById(R.id.group_text);
        textView.setText(groupText);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout, null);
        }

        TextView textView = (TextView) convertView
                .findViewById(R.id.child_text);
        textView.setText(childText);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}