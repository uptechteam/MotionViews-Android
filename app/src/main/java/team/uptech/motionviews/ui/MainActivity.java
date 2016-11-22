package team.uptech.motionviews.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import team.uptech.motionviews.R;
import team.uptech.motionviews.utils.FontProvider;
import team.uptech.motionviews.viewmodel.Font;
import team.uptech.motionviews.viewmodel.Layer;
import team.uptech.motionviews.viewmodel.TextLayer;
import team.uptech.motionviews.widget.MotionView;
import team.uptech.motionviews.widget.entity.ImageEntity;
import team.uptech.motionviews.widget.entity.TextEntity;

public class MainActivity extends AppCompatActivity {

    public static final int SELECT_STICKER_REQUEST_CODE = 123;

    protected MotionView motionView;

    private FontProvider fontProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.fontProvider = new FontProvider(getResources());

        motionView = (MotionView) findViewById(R.id.main_motion_view);

        addSticker(R.drawable.pikachu_2);

        addTextSticker();
    }

    protected void addTextSticker() {
        motionView.post(new Runnable() {
            @Override
            public void run() {
                TextLayer textLayer = createTextLayer();
                TextEntity textEntity = new TextEntity(textLayer, motionView.getWidth(),
                        motionView.getHeight(), fontProvider);
                motionView.addEntityAndPosition(textEntity);
            }
        });
    }

    private void addSticker(final int stickerResId) {
        motionView.post(new Runnable() {
            @Override
            public void run() {
                Layer layer = new Layer();
                Bitmap pica = BitmapFactory.decodeResource(getResources(), stickerResId);

                ImageEntity entity = new ImageEntity(layer, pica, motionView.getWidth(), motionView.getHeight());

                motionView.addEntityAndPosition(entity);
            }
        });
    }

    private TextLayer createTextLayer() {
        TextLayer textLayer = new TextLayer();
        Font font = new Font();
        font.setColor(TextLayer.Limits.INITIAL_FONT_COLOR);
        font.setSize(0.066F);//TextLayer.Limits.INITIAL_FONT_SIZE);
        // TODO: set typeface
        textLayer.setFont(font);

        textLayer.setText("Hello, world :))");
        return textLayer;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.main_add_sticker) {
            Intent intent = new Intent(this, StickerSelectActivity.class);
            startActivityForResult(intent, SELECT_STICKER_REQUEST_CODE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_STICKER_REQUEST_CODE) {
                if (data != null) {
                    int stickerId = data.getIntExtra(StickerSelectActivity.EXTRA_STICKER_ID, 0);
                    if (stickerId != 0) {
                        addSticker(stickerId);
                    }
                }
            }
        }
    }
}
