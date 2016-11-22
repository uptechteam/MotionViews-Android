package team.uptech.motionviews.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import team.uptech.motionviews.utils.FontProvider;

public class FontsAdapter extends ArrayAdapter<String> {

    private final LayoutInflater inflater;
    private final FontProvider fontProvider;

    public FontsAdapter(Context context, List<String> fontNames, FontProvider fontProvider) {
        super(context, 0, fontNames);
        this.inflater = LayoutInflater.from(context);
        this.fontProvider = fontProvider;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        String fontName = getItem(position);

        TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
        tv.setTypeface(fontProvider.getTypeface(fontName));

        tv.setText(fontName);

        return convertView;
    }
}