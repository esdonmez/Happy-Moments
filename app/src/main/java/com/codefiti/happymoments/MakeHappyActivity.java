package com.codefiti.happymoments;

import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.support.v4.view.ViewPager;
import android.widget.Toast;
import com.codefiti.happymoments.Adapters.ViewPagerAdapter;
import com.codeifit.happymoments.R;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MakeHappyActivity extends AppCompatActivity {
    final Context mContext = this;
    AlertDialog dialog = null;

    private static final String AUDIO_RECORDER_FILE_EXT_MP4 = ".mp4";
    private static final String AUDIO_RECORDER_FOLDER = "AudioRecorder";
    private MediaRecorder recorder = null;
    private MediaPlayer mPlayer;
    private int currentFormat = 0;
    private int output_format =  MediaRecorder.OutputFormat.MPEG_4;
    private String file_ext = "AUDIO_RECORDER_FILE_EXT_MP4";
    String fileName;

    AlertDialog.Builder dialogBuilder_voice;
    LayoutInflater inflater_voice;
    View dialogView_voice;
    Boolean start = false;

    LinearLayout textMessageButton;
    LinearLayout voiceMessageButton;
    SeekBar seekBar;
    public List<View> mList = new ArrayList<>();
    public List<View> _mList = new ArrayList<>();

    ViewPager pager;
    ViewPagerAdapter adapter;
    LinearLayout first, second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_happy);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        final View view2 = LayoutInflater.from(getApplication()).inflate(R.layout.new_card, null);

        pager = (ViewPager) findViewById(R.id.viewpager);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView seekBarValue = (TextView) findViewById(R.id.seekBarValue);
        textMessageButton = (LinearLayout) findViewById(R.id.textMessageButton);
        voiceMessageButton = (LinearLayout) findViewById(R.id.voiceMessageButton);
        mList.add(view2);
        _mList.add(view2);
        adapter = new ViewPagerAdapter(mContext, mList);
        pager.setAdapter(adapter);
        pager.setPageTransformer(true, new ZoomOutPageTransformer());

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creditCard_onClick(v);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = progress / 5;
                progress = progress * 5;
                seekBarValue.setText(String.valueOf(progress) + " TL");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        textMessageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                textMessage_onClick(v);
            }
        });

        voiceMessageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                voiceMessage_onClick(v);
            }
        });
    }

    public void creditCard_onClick(View v)
    {
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alert_dialog_card, null);
        dialogBuilder.setView(dialogView);

        dialogBuilder.setTitle("Kredi Karti Ekle");
        dialogBuilder.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.credit_cards, null);

                EditText nameSurname = (EditText) dialogView.findViewById(R.id.nameSurname);
                EditText cardNo = (EditText) dialogView.findViewById(R.id.cardNo);
                EditText month = (EditText) dialogView.findViewById(R.id.month);
                EditText year = (EditText) dialogView.findViewById(R.id.year);
                EditText cvc = (EditText) dialogView.findViewById(R.id.cvc);

                TextView _nameSurname = (TextView) addView.findViewById(R.id.nameSurname);
                TextView _cardNo = (TextView) addView.findViewById(R.id.cardNo);
                TextView _month = (TextView) addView.findViewById(R.id.month);
                TextView _year = (TextView) addView.findViewById(R.id.year);

                _nameSurname.setText(nameSurname.getText().toString());
                _cardNo.setText(cardNo.getText().toString());
                _month.setText(month.getText().toString());
                _year.setText(year.getText().toString());

                _mList.add(addView);
                mList.add(addView);
                for(int i = 0; i < _mList.size(); i++)
                {
                    mList.set(i, _mList.get(_mList.size() - 1 - i));
                }

                ((ViewPagerAdapter) pager.getAdapter()).notifyDataSetChanged();
                pager.setCurrentItem(0);
            }
        });
        dialogBuilder.setNegativeButton("Iptal Et", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void voiceMessage_onClick(View v)
    {
        dialogBuilder_voice = new AlertDialog.Builder(this);
        inflater_voice = this.getLayoutInflater();
        dialogView_voice = inflater_voice.inflate(R.layout.alert_dialog_voice, null);
        dialogBuilder_voice.setView(dialogView_voice);

        setButtonHandlers();
        enableButtons(false);

        dialogBuilder_voice.setTitle("Ses Kaydet");
        dialogBuilder_voice.setPositiveButton("Kaydet", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        dialogBuilder_voice.setNegativeButton("Iptal Et", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder_voice.create();
        b.show();
    }

    public void textMessage_onClick(View v)
    {
        // custom dialog
        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alert_dialog_text, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.editText);

        dialogBuilder.setMessage("Enter text below (140)");

        edt.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){
                dialog.setMessage("Enter text below (" + (140 - s.toString().length()) + ")");
            }
        });

        dialogBuilder.setTitle("Text Message");
        dialogBuilder.setPositiveButton("Mesaj Ekle", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        dialogBuilder.setNegativeButton("Iptal Et", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        dialog = dialogBuilder.create();
        dialog.show();
    }

    private void setButtonHandlers() {
        ((ImageView) dialogView_voice.findViewById(R.id.recordButton)).setOnClickListener(btnClick);
        ((Button) dialogView_voice.findViewById(R.id.stopButton)).setOnClickListener(btnClick);
        ((Button) dialogView_voice.findViewById(R.id.playButton)).setOnClickListener(btnClick);
    }

    private void enableButton(int id, boolean isEnable) {
        if(id == R.id.recordButton)
            ((ImageView) dialogView_voice.findViewById(id)).setEnabled(isEnable);
        else if(id == R.id.stopButton)
            ((Button) dialogView_voice.findViewById(id)).setEnabled(isEnable);
    }

    private void enableButtons(boolean isRecording) {
        enableButton(R.id.recordButton, !isRecording);
        enableButton(R.id.stopButton, isRecording);
    }

    private String getFilename() {
        String filepath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(filepath, AUDIO_RECORDER_FOLDER);

        if (!file.exists()) {
            file.mkdirs();
        }

        return (file.getAbsolutePath() + "/" + System.currentTimeMillis() + AUDIO_RECORDER_FILE_EXT_MP4);
    }

    private void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(fileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Toast.makeText(MakeHappyActivity.this, "prepare() failed", Toast.LENGTH_SHORT).show();
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }

    private void startRecording() {
        recorder = new MediaRecorder();

        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(output_format);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        fileName = getFilename();
        recorder.setOutputFile(fileName);

        recorder.setOnErrorListener(errorListener);
        recorder.setOnInfoListener(infoListener);

        try {
            recorder.prepare();
            recorder.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopRecording() {
        if (null != recorder) {
            recorder.stop();
            recorder.reset();
            recorder.release();

            recorder = null;
        }
    }

    private MediaRecorder.OnErrorListener errorListener = new MediaRecorder.OnErrorListener() {
        @Override
        public void onError(MediaRecorder mr, int what, int extra) {
            Toast.makeText(MakeHappyActivity.this,
                    "Error: " + what + ", " + extra, Toast.LENGTH_SHORT).show();
        }
    };

    private MediaRecorder.OnInfoListener infoListener = new MediaRecorder.OnInfoListener() {
        @Override
        public void onInfo(MediaRecorder mr, int what, int extra) {
            Toast.makeText(MakeHappyActivity.this,
                    "Warning: " + what + ", " + extra, Toast.LENGTH_SHORT)
                    .show();
        }
    };

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.recordButton: {
                    Toast.makeText(MakeHappyActivity.this, "Start Recording",
                            Toast.LENGTH_SHORT).show();

                    enableButtons(true);
                    startRecording();

                    break;
                }
                case R.id.stopButton: {
                    Toast.makeText(MakeHappyActivity.this, "Stop Recording",
                            Toast.LENGTH_SHORT).show();
                    enableButtons(false);
                    stopRecording();
                    break;
                }
                case R.id.playButton: {
                    start = !start;
                    onPlay(start);
                    break;
                }
            }
        }
    };
}