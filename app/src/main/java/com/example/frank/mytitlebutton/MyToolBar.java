package com.example.frank.mytitlebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyToolBar extends RelativeLayout {

	/**
	 * �������������ؼ�
	 */
	private Button leftBtn, rightBtn;
	private TextView title;

	/**
	 * ��߰�ť������
	 */
	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;

	/**
	 * �ұ߰�ť������
	 */
	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;

	/**
	 * �м�TextView������
	 */
	private int titleTextColor;
	private String titleText;
	private float titleTextSize;

	/**
	 * �����ؼ��Ĳ��ֲ���
	 */
	private LayoutParams leftParams, rightParams, titleParams;
	private OnToolBarClickListener listener;

	public interface OnToolBarClickListener {
		/**
		 * ��߰�ť����¼�
		 */
		public void leftClick();

		/**
		 * �ұ߰�ť����¼�
		 */
		public void rightClick();
	}

	public void setOnToolBarClickListener(OnToolBarClickListener listener) {
		this.listener = listener;
	}

	public MyToolBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.ToolBar);

		leftTextColor = ta.getColor(R.styleable.ToolBar_leftTextColor, 0);
		leftBackground = ta.getDrawable(R.styleable.ToolBar_leftBackground);
		leftText = ta.getString(R.styleable.ToolBar_leftText);

		rightTextColor = ta.getColor(R.styleable.ToolBar_rightTextColor, 0);
		rightBackground = ta.getDrawable(R.styleable.ToolBar_rightBackground);
		rightText = ta.getString(R.styleable.ToolBar_rightText);

		titleText = ta.getString(R.styleable.ToolBar_title);
		titleTextColor = ta.getColor(R.styleable.ToolBar_titleTextColor, 0);
		titleTextSize = ta.getDimension(R.styleable.ToolBar_titleTextSize, 0);


		//��ta���л���
		ta.recycle();

		leftBtn = new Button(context);
		rightBtn = new Button(context);
		title = new TextView(context);

		/**
		 * ��������
		 */
		leftBtn.setText(leftText);
		leftBtn.setTextColor(leftTextColor);
		leftBtn.setBackground(leftBackground);

		rightBtn.setText(rightText);
		rightBtn.setTextColor(rightTextColor);
		rightBtn.setBackground(rightBackground);

		title.setText(titleText);
		title.setTextColor(titleTextColor);
		title.setTextSize(titleTextSize);
		title.setGravity(Gravity.CENTER);

		//�������屳����ɫ
		setBackgroundColor(0x7CFC0055);

		leftParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
		//��ӿؼ�
		addView(leftBtn, leftParams);

		rightParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		addView(rightBtn, rightParams);

		titleParams = new LayoutParams(
				android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
				android.view.ViewGroup.LayoutParams.MATCH_PARENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		addView(title, titleParams);

		leftBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.leftClick();
			}
		});
		rightBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.rightClick();
			}
		});
	}

}
