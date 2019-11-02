package com.circulationapp.calculator.calculatorfree.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.circulationapp.calculator.R;
import com.circulationapp.calculator.calculatorfree.util.AppUtil;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.math.BigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.layout_banner_ads)
    LinearLayout layoutBannerAds;
    @BindView(R.id.layout_ads)
    RelativeLayout layoutAds;
    @BindView(R.id.txtOperator)
    TextView txtOperator;
    @BindView(R.id.hzw)
    HorizontalScrollView hzw;
    @BindView(R.id.txtResult)
    TextView txtResult;
    @BindView(R.id.btnC)
    Button btnC;
    @BindView(R.id.btnBracket)
    Button btnBracket;
    @BindView(R.id.btnPercent)
    Button btnPercent;
    @BindView(R.id.btnXoa)
    ImageView btnXoa;
    @BindView(R.id.layoutRow1)
    LinearLayout layoutRow1;
    @BindView(R.id.btn7)
    Button btn7;
    @BindView(R.id.btn8)
    Button btn8;
    @BindView(R.id.btn9)
    Button btn9;
    @BindView(R.id.btnDiv)
    Button btnDiv;
    @BindView(R.id.layoutRow2)
    LinearLayout layoutRow2;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btnMul)
    Button btnMul;
    @BindView(R.id.layoutRow3)
    LinearLayout layoutRow3;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btnSub)
    Button btnSub;
    @BindView(R.id.layoutRow4)
    LinearLayout layoutRow4;
    @BindView(R.id.btnDecimal)
    Button btnDecimal;
    @BindView(R.id.btn0)
    Button btn0;
    @BindView(R.id.btnEquals)
    Button btnEquals;
    @BindView(R.id.btnPlus)
    Button btnPlus;
    @BindView(R.id.layoutRow5)
    LinearLayout layoutRow5;
    private String ID_ADS_GG = "ca-app-pub-3940256099942544/6300978111";
    private AdView adBanner;
    private boolean equalClicked = false;
    private String lastExpression = "";
    private int openParenthesis = 0;
    ScriptEngine scriptEngine;
    private boolean useDot = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind((Activity) this);
        this.scriptEngine = new ScriptEngineManager().getEngineByName("rhino");
        getWindow().setSoftInputMode(32);
        this.txtResult.setText("0");
        showBannerGG();
    }

    public void focusRight() {
        this.hzw.post(new Runnable() {
            public void run() {
                MainActivity.this.hzw.fullScroll(66);
            }
        });
    }
    private void showBannerGG() {
        this.adBanner = new AdView(this);
        this.adBanner.setAdSize(AdSize.BANNER);
        this.adBanner.setAdUnitId(this.ID_ADS_GG);
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        adRequestBuilder.addTestDevice(AdRequest.DEVICE_ID_EMULATOR);
        adRequestBuilder.addTestDevice("A83F9C494EFE301841A1EBF407492B97");
        this.layoutBannerAds.addView(this.adBanner);
        this.adBanner.loadAd(adRequestBuilder.build());
        this.adBanner.setAdListener(new AdListener() {
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                MainActivity.this.layoutBannerAds.removeAllViews();
            }

            public void onAdLoaded() {
                super.onAdLoaded();
            }
        });
    }

    @OnClick({R.id.btnC, R.id.btnBracket, R.id.btnPercent, R.id.btnPlus,  R.id.btn7,  R.id.btn8,  R.id.btn9, R.id.btnDiv,  R.id.btn4,  R.id.btn5,  R.id.btn6, R.id.btnMul, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btnXoa, R.id.btn0, R.id.btnDecimal, R.id.btnEquals, R.id.btnSub})
    public void onViewClicked(View view) {
        String str = "";
        String str2 = "0";
        switch (view.getId()) {
            case R.id.btn0:
                if (addNumber(str2)) {
                    this.equalClicked = false;
                }
                if (checkOperator(this.txtOperator.getText().toString())) {
                    calculate(this.txtOperator.getText().toString(), 1);
                }
                focusRight();
                return;
            case R.id.btn1:
                if (addNumber("1")) {
                    this.equalClicked = false;
                }
                if (checkOperator(this.txtOperator.getText().toString())) {
                    calculate(this.txtOperator.getText().toString(), 1);
                }
                focusRight();
                return;
            case R.id.btn2:
                if (addNumber("2")) {
                    this.equalClicked = false;
                }
                if (checkOperator(this.txtOperator.getText().toString())) {
                    calculate(this.txtOperator.getText().toString(), 1);
                }
                focusRight();
                return;
            case R.id.btn3:
                if (addNumber("3")) {
                    this.equalClicked = false;
                }
                if (checkOperator(this.txtOperator.getText().toString())) {
                    calculate(this.txtOperator.getText().toString(), 1);
                }
                focusRight();
                return;
            case R.id.btn4:
                if (addNumber("4")) {
                    this.equalClicked = false;
                }
                if (checkOperator(this.txtOperator.getText().toString())) {
                    calculate(this.txtOperator.getText().toString(), 1);
                }
                focusRight();
                return;
            case R.id.btn5:
                if (addNumber("5")) {
                    this.equalClicked = false;
                }
                if (checkOperator(this.txtOperator.getText().toString())) {
                    calculate(this.txtOperator.getText().toString(), 1);
                }
                focusRight();
                return;
            case R.id.btn6:
                if (addNumber("6")) {
                    this.equalClicked = false;
                }
                if (checkOperator(this.txtOperator.getText().toString())) {
                    calculate(this.txtOperator.getText().toString(), 1);
                }
                focusRight();
                return;
            case R.id.btn7 :
                if (addNumber("7")) {
                    this.equalClicked = false;
                }
                if (checkOperator(this.txtOperator.getText().toString())) {
                    calculate(this.txtOperator.getText().toString(), 1);
                }
                focusRight();
                return;
            case R.id.btn8:
                if (addNumber("8")) {
                    this.equalClicked = false;
                }
                if (checkOperator(this.txtOperator.getText().toString())) {
                    calculate(this.txtOperator.getText().toString(), 1);
                }
                focusRight();
                return;
            case R.id.btn9:
                if (addNumber("9")) {
                    this.equalClicked = false;
                }
                if (checkOperator(this.txtOperator.getText().toString())) {
                    calculate(this.txtOperator.getText().toString(), 1);
                }
                focusRight();
                return;
            case R.id.btnBracket:
                if (addParenthesis()) {
                    this.equalClicked = false;
                }
                focusRight();
                return;
            case R.id.btnC:
                this.txtOperator.setText(str);
                this.txtResult.setText(str2);
                this.openParenthesis = 0;
                this.useDot = false;
                this.equalClicked = false;
                return;
            case R.id.btnDecimal:
                if (addDot()) {
                    this.equalClicked = false;
                }
                focusRight();
                return;
            case R.id.btnDiv:
                if (addOperator("÷")) {
                    this.equalClicked = false;
                }
                focusRight();
                return;
            case R.id.btnEquals :
                if (this.txtOperator.getText().toString() != null && !this.txtOperator.getText().toString().equals(str)) {
                    calculate(this.txtOperator.getText().toString(), 0);
                }
                focusRight();
                return;
            case R.id.btnMul:
                if (addOperator("x")) {
                    this.equalClicked = false;
                }
                focusRight();
                return;
            case R.id.btnPercent:
                if (addOperator("%")) {
                    this.equalClicked = false;
                }
                focusRight();
                return;
            case R.id.btnPlus:
                if (addOperator("+")) {
                    this.equalClicked = false;
                }
                focusRight();
                return;
            case R.id.btnSub:
                if (addOperator("-")) {
                    this.equalClicked = false;
                }
                focusRight();
                return;
            case R.id.btnXoa:
                removeText();
                focusRight();
                return;
            default:
                return;
        }
    }

    private boolean addNumber(String number) {
        int operationLength = this.txtOperator.getText().length();
        if (operationLength > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.txtOperator.getText().charAt(operationLength - 1));
            sb.append("");
            String lastCharacter = sb.toString();
            int lastCharacterState = AppUtil.defineLastCharacter(lastCharacter);
            if (operationLength == 1 && lastCharacterState == 0 && lastCharacter.equals("0")) {
                this.txtOperator.setText(number);
                return true;
            } else if (lastCharacterState == 2) {
                TextView textView = this.txtOperator;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.txtOperator.getText());
                sb2.append(number);
                textView.setText(sb2.toString());
                return true;
            } else if (lastCharacterState == 3 || lastCharacter.equals("%")) {
                TextView textView2 = this.txtOperator;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(this.txtOperator.getText());
                sb3.append("x");
                sb3.append(number);
                textView2.setText(sb3.toString());
                return true;
            } else if (lastCharacterState != 0 && lastCharacterState != 1 && lastCharacterState != 4) {
                return false;
            } else {
                TextView textView3 = this.txtOperator;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.txtOperator.getText());
                sb4.append(number);
                textView3.setText(sb4.toString());
                return true;
            }
        } else {
            TextView textView4 = this.txtOperator;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.txtOperator.getText());
            sb5.append(number);
            textView4.setText(sb5.toString());
            return true;
        }
    }

    public void removeText() {
        int operationLength = this.txtOperator.getText().length();
        String currentText = this.txtOperator.getText().toString();
        if (operationLength > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.txtOperator.getText().charAt(this.txtOperator.getText().length() - 1));
            sb.append("");
            String sb2 = sb.toString();
            this.txtOperator.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    private boolean addOperator(String operand) {
        int operationLength = this.txtOperator.getText().length();
        if (operationLength > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.txtOperator.getText().charAt(operationLength - 1));
            String str = "";
            sb.append(str);
            String lastInput = sb.toString();
            if (!lastInput.equals("+") && !lastInput.equals("-") && !lastInput.equals("x") && !lastInput.equals("÷")) {
                String str2 = "%";
                if (!lastInput.equals(str2)) {
                    if (operand.equals(str2) && AppUtil.defineLastCharacter(lastInput) == 0) {
                        TextView textView = this.txtOperator;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(this.txtOperator.getText());
                        sb2.append(operand);
                        textView.setText(sb2.toString());
                        this.useDot = false;
                        this.equalClicked = false;
                        this.lastExpression = str;
                        return true;
                    } else if (operand.equals(str2)) {
                        return false;
                    } else {
                        TextView textView2 = this.txtOperator;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(this.txtOperator.getText());
                        sb3.append(operand);
                        textView2.setText(sb3.toString());
                        this.useDot = false;
                        this.equalClicked = false;
                        this.lastExpression = str;
                        return true;
                    }
                }
            }
            Toast.makeText(getApplicationContext(), "Wrong format", Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(getApplicationContext(), "Wrong Format. Operand Without any numbers?", Toast.LENGTH_SHORT).show();
        return false;
    }

    public boolean checkOperator(String input) {
        if (input.contains("+") || input.contains("-") || input.contains("x") || input.contains("÷")) {
            return true;
        }
        return false;
    }

    private void calculate(String input, int keyCode) {
        String str = "";
        String temp = input;
        try {
            if (this.equalClicked) {
                StringBuilder sb = new StringBuilder();
                sb.append(input);
                sb.append(this.lastExpression);
                temp = sb.toString();
            } else {
                AppUtil.saveLastExpression(this.lastExpression, input);
            }
            String result = new BigDecimal(this.scriptEngine.eval(temp.replaceAll("%", "/100").replaceAll("x", "*").replaceAll("÷", "/")).toString()).setScale(8, 4).toPlainString();
            this.equalClicked = true;
            if (result.equals("Infinity") && keyCode == 1) {
                Toast.makeText(getApplicationContext(), "Division by zero is not allowed", Toast.LENGTH_SHORT).show();
                this.txtOperator.setText(input);
            } else if (result.contains(".")) {
                this.txtResult.setText(result.replaceAll("\\.?0*$", ""));
            }
        } catch (Exception e) {
            if (keyCode != 1) {
                Toast.makeText(getApplicationContext(), "Wrong Format",  Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean addParenthesis() {
        int operationLength = this.txtOperator.getText().length();
        String str = "(";
        if (operationLength == 0) {
            TextView textView = this.txtOperator;
            StringBuilder sb = new StringBuilder();
            sb.append(this.txtOperator.getText());
            sb.append(str);
            textView.setText(sb.toString());
            this.useDot = false;
            this.openParenthesis++;
            return true;
        }
        String str2 = "";
        if (this.openParenthesis > 0 && operationLength > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.txtOperator.getText().charAt(operationLength - 1));
            sb2.append(str2);
            int defineLastCharacter = AppUtil.defineLastCharacter(sb2.toString());
            if (defineLastCharacter != 0) {
                if (defineLastCharacter == 1 || defineLastCharacter == 2) {
                    TextView textView2 = this.txtOperator;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.txtOperator.getText());
                    sb3.append(str);
                    textView2.setText(sb3.toString());
                    this.openParenthesis++;
                    this.useDot = false;
                    return true;
                } else if (defineLastCharacter != 3) {
                    return false;
                }
            }
            TextView textView3 = this.txtOperator;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.txtOperator.getText());
            sb4.append(")");
            textView3.setText(sb4.toString());
            this.openParenthesis--;
            this.useDot = false;
            return true;
        } else if (this.openParenthesis != 0 || operationLength <= 0) {
            return false;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.txtOperator.getText().charAt(operationLength - 1));
            sb5.append(str2);
            if (AppUtil.defineLastCharacter(sb5.toString()) == 1) {
                TextView textView4 = this.txtOperator;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(this.txtOperator.getText());
                sb6.append(str);
                textView4.setText(sb6.toString());
                this.useDot = false;
                this.openParenthesis++;
                return true;
            }
            TextView textView5 = this.txtOperator;
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.txtOperator.getText());
            sb7.append("x(");
            textView5.setText(sb7.toString());
            this.useDot = false;
            this.openParenthesis++;
            return true;
        }
    }

    private boolean addDot() {
        String str = "0.";
        if (this.txtOperator.getText().length() == 0) {
            this.txtOperator.setText(str);
            this.useDot = true;
            return true;
        } else if (this.useDot) {
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.txtOperator.getText().charAt(this.txtOperator.getText().length() - 1));
            String str2 = "";
            sb.append(str2);
            if (AppUtil.defineLastCharacter(sb.toString()) == 1) {
                TextView textView = this.txtOperator;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.txtOperator.getText());
                sb2.append(str);
                textView.setText(sb2.toString());
                this.useDot = true;
                return true;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.txtOperator.getText().charAt(this.txtOperator.getText().length() - 1));
            sb3.append(str2);
            if (AppUtil.defineLastCharacter(sb3.toString()) != 0) {
                return false;
            }
            TextView textView2 = this.txtOperator;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(this.txtOperator.getText());
            sb4.append(".");
            textView2.setText(sb4.toString());
            this.useDot = true;
            return true;
        }
    }
}
