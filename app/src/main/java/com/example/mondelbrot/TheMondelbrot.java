package com.example.mondelbrot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class TheMondelbrot extends View {//пока я не понимаю как разбить на классы и сделаю в 1 классе

    public TheMondelbrot(Context context) {//инициализируем проект
        super(context);
    }

    protected void onDraw(Canvas canvas) {// Метод onDraw вызывается операционной системой при старте активности
        //тут будем рисовать
        super.onDraw(canvas);
        Paint paint = new Paint();

        // Выбираем кисть
        paint.setStyle(Paint.Style.FILL);
        // Белый цвет кисти
        paint.setColor(Color.BLACK);
        // Закрашиваем холст
        canvas.drawPaint(paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.BLUE);

        //osi
        paint.setStrokeWidth(7);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), paint);

        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, paint);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), paint);

        canvas.drawLine(0, getHeight() / 2, 15, getHeight() / 2 + 15, paint);
        canvas.drawLine(0, getHeight() / 2, 15, getHeight() / 2 - 15, paint);

        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2 - 15, 15, paint);
        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2 + 15, 15, paint);

        paint.setStrokeWidth(1);
        paint.setColor(Color.WHITE);
        float k_x = getHeight() / 4;
        float k_y = getWidth() / 2;
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if (GoToBesk(0, 0, (-y + getHeight() / 2) / k_x, (-x + getWidth() / 2) / k_y, 0)) {
                    canvas.drawPoint(x, y, paint);
                }
            }
        }
    }


    private boolean GoToBesk(float A, float B, float x, float y, int n) {
        if (n == 100) {
            return A * A + B * B <= 4;
        }
        return GoToBesk(A * A - B * B + x, 2 * A * B + y, x, y, n + 1);
    }
}
