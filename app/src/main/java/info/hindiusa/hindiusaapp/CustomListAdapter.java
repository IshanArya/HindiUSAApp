package info.hindiusa.hindiusaapp;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ishanarya on 11/23/16.
 */

public class CustomListAdapter extends ArrayAdapter<Entry> {


    private final int listViewElement;
    private List<Entry> entries;
    private boolean isOrange = true;

    public CustomListAdapter(Activity context, int listViewElement, List<Entry> entries) {
        super(context, listViewElement, entries);

        this.listViewElement = listViewElement;
        this.entries = entries;

    }

    public List<Entry> getEntries() {
        return entries;
    }

    private static class EntryViewHolder {
        TextView subjectTextView, messageTextView, dateTextView;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        EntryViewHolder entryViewHolder;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(listViewElement, null);
            entryViewHolder = new EntryViewHolder();
            entryViewHolder.subjectTextView = (TextView) view.findViewById(R.id.subject);
            entryViewHolder.messageTextView = (TextView) view.findViewById(R.id.message);
            entryViewHolder.dateTextView = (TextView) view.findViewById(R.id.date);
            view.setTag(entryViewHolder);
        } else {
            entryViewHolder = (EntryViewHolder) view.getTag();
        }
        Entry entry = getItem(position);
        String message = entry.getMessage();
        message = (message.length() > 40) ? (message.substring(0, 40) + "...") : message;
        entryViewHolder.subjectTextView.setText(entry.getSubject());
        entryViewHolder.messageTextView.setText(message);
        entryViewHolder.dateTextView.setText(entry.getFullDate());
        view.setBackgroundColor(ContextCompat.getColor(getContext(), isOrange ? R.color.lightOrange : R.color.lightGreen));
        isOrange = !isOrange;
        return view;
    }
}
