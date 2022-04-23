package com.ecloud.eshare.util;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes.dex */
public class n implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    private int f2924b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f2925c;

    public n(int i, EditText editText) {
        this.f2924b = 0;
        this.f2925c = null;
        this.f2924b = i;
        this.f2925c = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Editable text = this.f2925c.getText();
        if (text.length() > this.f2924b) {
            int selectionEnd = Selection.getSelectionEnd(text);
            this.f2925c.setText(text.toString().substring(0, this.f2924b));
            Editable text2 = this.f2925c.getText();
            if (selectionEnd > text2.length()) {
                selectionEnd = text2.length();
            }
            Selection.setSelection(text2, selectionEnd);
        }
    }
}
