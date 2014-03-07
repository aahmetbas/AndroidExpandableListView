package com.mete.yunus.expandable.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpListAdapter extends BaseExpandableListAdapter{
	
	private Context context;
	private ArrayList<String> basliklar;
	private HashMap<String, ArrayList<String>> icerik;

	public ExpListAdapter(Context context, ArrayList<String> basliklar,
			HashMap<String, ArrayList<String>> icerik) {
		super();
		this.context = context;
		this.basliklar = basliklar;
		this.icerik = icerik;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return icerik.get(basliklar.get(groupPosition)).get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		// TODO Auto-generated method stub
		String text = (String) getChild(groupPosition, childPosition);
		
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(com.mete.yunus.expandable.R.layout.liste_item, null);
		}
		
		TextView tvText = (TextView) convertView.findViewById(com.mete.yunus.expandable.R.id.textView1);
		tvText.setText(text);
		
		
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return icerik.get(basliklar.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return basliklar.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return basliklar.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String baslik = (String) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(com.mete.yunus.expandable.R.layout.liste_grup, null);
			
		}
		
		TextView tvBaslik = (TextView) convertView.findViewById(com.mete.yunus.expandable.R.id.textView1);
		tvBaslik.setText(baslik);
		tvBaslik.setTypeface(null, Typeface.BOLD);
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}
