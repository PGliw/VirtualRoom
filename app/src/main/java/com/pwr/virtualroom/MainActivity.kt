package com.pwr.virtualroom

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnTouchListener, GestureDetector.OnGestureListener {

    companion object {
        const val TAG = "MainActivity"
        // All frames boundaries
        const val START_FRAME_INDEX = 0
        const val END_FRAME_INDEX = 400
        // Tv button frames boundaries
        const val TV_BUTTON_START_FRAME_INDEX = 0
        const val TV_BUTTON_END_FRAME_INDEX = 40
        // Bookcase button frames boundaries
        const val BOOKCASE_BUTTON_START_FRAME_INDEX = 230
        const val BOOKCASE_BUTTON_END_FRAME_INDEX = 380it
        // Vases button frames boundaries
        const val VASES_BUTTON_START_FRAME_INDEX = 50
        const val VASES_BUTTON_END_FRAME_INDEX = 150
    }

    private var currentIndex = 0
    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        renderImage(currentIndex)
        renderTvButton(currentIndex)
        renderBookcaseButton(currentIndex)
        renderVasesButton(currentIndex)

        image_main_activity_virtual_room.setOnTouchListener(this)
        gestureDetector = GestureDetector(this, this)

        image_button_tv_circle.setOnClickListener {
            renderTvPopup(this)
        }
        image_button_vases_circle.setOnClickListener {
            renderVasesPopup(this)
        }
        image_button_bookcase_circle.setOnClickListener {
            renderBookcasePopup(this)
        }

    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        val frameShift = distanceToFrames(distanceX)
        // Log.i(TAG, "OnGestureListener.onScroll: dX=$distanceX, dY=$distanceY, shift=$frameShift frames")
        moveRoom(frameShift)
        return false
    }

    private fun distanceToFrames(distanceX: Float): Int {
        val framesToDistanceFactor = 0.5
        val framesShift = framesToDistanceFactor * distanceX
        return framesShift.toInt()
    }

    private fun moveRoom(frameShift: Int = 1) {
        val targetFrame = currentIndex + frameShift
        if (targetFrame in START_FRAME_INDEX..END_FRAME_INDEX) {
            currentIndex = targetFrame
            renderImage(currentIndex)
            renderTvButton(currentIndex)
            renderBookcaseButton(currentIndex)
            renderVasesButton(currentIndex)
        }
    }

    private fun renderTvButton(index: Int){
        if(index in TV_BUTTON_START_FRAME_INDEX..TV_BUTTON_END_FRAME_INDEX){
            // val progress = index / abs(TV_BUTTON_END_FRAME_INDEX - TV_BUTTON_START_FRAME_INDEX)
            image_button_tv_circle.visibility = View.VISIBLE
        }
        else{
            image_button_tv_circle.visibility = View.GONE
        }
    }

    private fun renderTvPopup(context: Context){
       AlertDialog.Builder(context).setMessage(R.string.tv_popup_message).show()
    }

    private fun renderVasesPopup(context: Context){
        AlertDialog.Builder(context).setMessage(R.string.vases_popup_message).show()
    }

    private fun renderBookcasePopup(context: Context){
        AlertDialog.Builder(context).setMessage(R.string.bookcase_popup_message).show()
    }

    private fun renderBookcaseButton(index: Int){
        if(index in BOOKCASE_BUTTON_START_FRAME_INDEX..BOOKCASE_BUTTON_END_FRAME_INDEX){
            image_button_bookcase_circle.visibility = View.VISIBLE
        }
        else {
            image_button_bookcase_circle.visibility = View.GONE
        }
    }

    private fun renderVasesButton(index: Int){
        if(index in VASES_BUTTON_START_FRAME_INDEX..VASES_BUTTON_END_FRAME_INDEX){
            image_button_vases_circle.visibility = View.VISIBLE
        }
        else {
            image_button_vases_circle.visibility = View.GONE
        }
    }

    private fun renderImage(index: Int = 0) {
        if (index in START_FRAME_INDEX..END_FRAME_INDEX)
            image_main_activity_virtual_room.setImageResource(images[index])
        else Log.e(TAG, "Indeks $index poza zakresem")
    }

    override fun onLongPress(e: MotionEvent?) {
        // Log.i(TAG, "OnGestureListener.onLongPress")
    }

    override fun onShowPress(e: MotionEvent?) {
//        Log.i(TAG, "OnGestureListener.onShowPress")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
//        Log.i(TAG, "OnGestureListener.onSingleTapUp")
        return false
    }

    override fun onDown(e: MotionEvent?): Boolean {
//        Log.i(TAG, "OnGestureListener.onDown")
        return false
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
//        Log.i(TAG, "OnGestureListener.onFling")
        return false
    }


    private val images = arrayOf(
        R.drawable.room0000,
        R.drawable.room0001,
        R.drawable.room0002,
        R.drawable.room0003,
        R.drawable.room0004,
        R.drawable.room0005,
        R.drawable.room0006,
        R.drawable.room0007,
        R.drawable.room0008,
        R.drawable.room0009,
        R.drawable.room0010,
        R.drawable.room0011,
        R.drawable.room0012,
        R.drawable.room0013,
        R.drawable.room0014,
        R.drawable.room0015,
        R.drawable.room0016,
        R.drawable.room0017,
        R.drawable.room0018,
        R.drawable.room0019,
        R.drawable.room0020,
        R.drawable.room0021,
        R.drawable.room0022,
        R.drawable.room0023,
        R.drawable.room0024,
        R.drawable.room0025,
        R.drawable.room0026,
        R.drawable.room0027,
        R.drawable.room0028,
        R.drawable.room0029,
        R.drawable.room0030,
        R.drawable.room0031,
        R.drawable.room0032,
        R.drawable.room0033,
        R.drawable.room0034,
        R.drawable.room0035,
        R.drawable.room0036,
        R.drawable.room0037,
        R.drawable.room0038,
        R.drawable.room0039,
        R.drawable.room0040,
        R.drawable.room0041,
        R.drawable.room0042,
        R.drawable.room0043,
        R.drawable.room0044,
        R.drawable.room0045,
        R.drawable.room0046,
        R.drawable.room0047,
        R.drawable.room0048,
        R.drawable.room0049,
        R.drawable.room0050,
        R.drawable.room0051,
        R.drawable.room0052,
        R.drawable.room0053,
        R.drawable.room0054,
        R.drawable.room0055,
        R.drawable.room0056,
        R.drawable.room0057,
        R.drawable.room0058,
        R.drawable.room0059,
        R.drawable.room0060,
        R.drawable.room0061,
        R.drawable.room0062,
        R.drawable.room0063,
        R.drawable.room0064,
        R.drawable.room0065,
        R.drawable.room0066,
        R.drawable.room0067,
        R.drawable.room0068,
        R.drawable.room0069,
        R.drawable.room0070,
        R.drawable.room0071,
        R.drawable.room0072,
        R.drawable.room0073,
        R.drawable.room0074,
        R.drawable.room0075,
        R.drawable.room0076,
        R.drawable.room0077,
        R.drawable.room0078,
        R.drawable.room0079,
        R.drawable.room0080,
        R.drawable.room0081,
        R.drawable.room0082,
        R.drawable.room0083,
        R.drawable.room0084,
        R.drawable.room0085,
        R.drawable.room0086,
        R.drawable.room0087,
        R.drawable.room0088,
        R.drawable.room0089,
        R.drawable.room0090,
        R.drawable.room0091,
        R.drawable.room0092,
        R.drawable.room0093,
        R.drawable.room0094,
        R.drawable.room0095,
        R.drawable.room0096,
        R.drawable.room0097,
        R.drawable.room0098,
        R.drawable.room0099,
        R.drawable.room0100,
        R.drawable.room0101,
        R.drawable.room0102,
        R.drawable.room0103,
        R.drawable.room0104,
        R.drawable.room0105,
        R.drawable.room0106,
        R.drawable.room0107,
        R.drawable.room0108,
        R.drawable.room0109,
        R.drawable.room0110,
        R.drawable.room0111,
        R.drawable.room0112,
        R.drawable.room0113,
        R.drawable.room0114,
        R.drawable.room0115,
        R.drawable.room0116,
        R.drawable.room0117,
        R.drawable.room0118,
        R.drawable.room0119,
        R.drawable.room0120,
        R.drawable.room0121,
        R.drawable.room0122,
        R.drawable.room0123,
        R.drawable.room0124,
        R.drawable.room0125,
        R.drawable.room0126,
        R.drawable.room0127,
        R.drawable.room0128,
        R.drawable.room0129,
        R.drawable.room0130,
        R.drawable.room0131,
        R.drawable.room0132,
        R.drawable.room0133,
        R.drawable.room0134,
        R.drawable.room0135,
        R.drawable.room0136,
        R.drawable.room0137,
        R.drawable.room0138,
        R.drawable.room0139,
        R.drawable.room0140,
        R.drawable.room0141,
        R.drawable.room0142,
        R.drawable.room0143,
        R.drawable.room0144,
        R.drawable.room0145,
        R.drawable.room0146,
        R.drawable.room0147,
        R.drawable.room0148,
        R.drawable.room0149,
        R.drawable.room0150,
        R.drawable.room0151,
        R.drawable.room0152,
        R.drawable.room0153,
        R.drawable.room0154,
        R.drawable.room0155,
        R.drawable.room0156,
        R.drawable.room0157,
        R.drawable.room0158,
        R.drawable.room0159,
        R.drawable.room0160,
        R.drawable.room0161,
        R.drawable.room0162,
        R.drawable.room0163,
        R.drawable.room0164,
        R.drawable.room0165,
        R.drawable.room0166,
        R.drawable.room0167,
        R.drawable.room0168,
        R.drawable.room0169,
        R.drawable.room0170,
        R.drawable.room0171,
        R.drawable.room0172,
        R.drawable.room0173,
        R.drawable.room0174,
        R.drawable.room0175,
        R.drawable.room0176,
        R.drawable.room0177,
        R.drawable.room0178,
        R.drawable.room0179,
        R.drawable.room0180,
        R.drawable.room0181,
        R.drawable.room0182,
        R.drawable.room0183,
        R.drawable.room0184,
        R.drawable.room0185,
        R.drawable.room0186,
        R.drawable.room0187,
        R.drawable.room0188,
        R.drawable.room0189,
        R.drawable.room0190,
        R.drawable.room0191,
        R.drawable.room0192,
        R.drawable.room0193,
        R.drawable.room0194,
        R.drawable.room0195,
        R.drawable.room0196,
        R.drawable.room0197,
        R.drawable.room0198,
        R.drawable.room0199,
        R.drawable.room0200,
        R.drawable.room0201,
        R.drawable.room0202,
        R.drawable.room0203,
        R.drawable.room0204,
        R.drawable.room0205,
        R.drawable.room0206,
        R.drawable.room0207,
        R.drawable.room0208,
        R.drawable.room0209,
        R.drawable.room0210,
        R.drawable.room0211,
        R.drawable.room0212,
        R.drawable.room0213,
        R.drawable.room0214,
        R.drawable.room0215,
        R.drawable.room0216,
        R.drawable.room0217,
        R.drawable.room0218,
        R.drawable.room0219,
        R.drawable.room0220,
        R.drawable.room0221,
        R.drawable.room0222,
        R.drawable.room0223,
        R.drawable.room0224,
        R.drawable.room0225,
        R.drawable.room0226,
        R.drawable.room0227,
        R.drawable.room0228,
        R.drawable.room0229,
        R.drawable.room0230,
        R.drawable.room0231,
        R.drawable.room0232,
        R.drawable.room0233,
        R.drawable.room0234,
        R.drawable.room0235,
        R.drawable.room0236,
        R.drawable.room0237,
        R.drawable.room0238,
        R.drawable.room0239,
        R.drawable.room0240,
        R.drawable.room0241,
        R.drawable.room0242,
        R.drawable.room0243,
        R.drawable.room0244,
        R.drawable.room0245,
        R.drawable.room0246,
        R.drawable.room0247,
        R.drawable.room0248,
        R.drawable.room0249,
        R.drawable.room0250,
        R.drawable.room0251,
        R.drawable.room0252,
        R.drawable.room0253,
        R.drawable.room0254,
        R.drawable.room0255,
        R.drawable.room0256,
        R.drawable.room0257,
        R.drawable.room0258,
        R.drawable.room0259,
        R.drawable.room0260,
        R.drawable.room0261,
        R.drawable.room0262,
        R.drawable.room0263,
        R.drawable.room0264,
        R.drawable.room0265,
        R.drawable.room0266,
        R.drawable.room0267,
        R.drawable.room0268,
        R.drawable.room0269,
        R.drawable.room0270,
        R.drawable.room0271,
        R.drawable.room0272,
        R.drawable.room0273,
        R.drawable.room0274,
        R.drawable.room0275,
        R.drawable.room0276,
        R.drawable.room0277,
        R.drawable.room0278,
        R.drawable.room0279,
        R.drawable.room0280,
        R.drawable.room0281,
        R.drawable.room0282,
        R.drawable.room0283,
        R.drawable.room0284,
        R.drawable.room0285,
        R.drawable.room0286,
        R.drawable.room0287,
        R.drawable.room0288,
        R.drawable.room0289,
        R.drawable.room0290,
        R.drawable.room0291,
        R.drawable.room0292,
        R.drawable.room0293,
        R.drawable.room0294,
        R.drawable.room0295,
        R.drawable.room0296,
        R.drawable.room0297,
        R.drawable.room0298,
        R.drawable.room0299,
        R.drawable.room0300,
        R.drawable.room0301,
        R.drawable.room0302,
        R.drawable.room0303,
        R.drawable.room0304,
        R.drawable.room0305,
        R.drawable.room0306,
        R.drawable.room0307,
        R.drawable.room0308,
        R.drawable.room0309,
        R.drawable.room0310,
        R.drawable.room0311,
        R.drawable.room0312,
        R.drawable.room0313,
        R.drawable.room0314,
        R.drawable.room0315,
        R.drawable.room0316,
        R.drawable.room0317,
        R.drawable.room0318,
        R.drawable.room0319,
        R.drawable.room0320,
        R.drawable.room0321,
        R.drawable.room0322,
        R.drawable.room0323,
        R.drawable.room0324,
        R.drawable.room0325,
        R.drawable.room0326,
        R.drawable.room0327,
        R.drawable.room0328,
        R.drawable.room0329,
        R.drawable.room0330,
        R.drawable.room0331,
        R.drawable.room0332,
        R.drawable.room0333,
        R.drawable.room0334,
        R.drawable.room0335,
        R.drawable.room0336,
        R.drawable.room0337,
        R.drawable.room0338,
        R.drawable.room0339,
        R.drawable.room0340,
        R.drawable.room0341,
        R.drawable.room0342,
        R.drawable.room0343,
        R.drawable.room0344,
        R.drawable.room0345,
        R.drawable.room0346,
        R.drawable.room0347,
        R.drawable.room0348,
        R.drawable.room0349,
        R.drawable.room0350,
        R.drawable.room0351,
        R.drawable.room0352,
        R.drawable.room0353,
        R.drawable.room0354,
        R.drawable.room0355,
        R.drawable.room0356,
        R.drawable.room0357,
        R.drawable.room0358,
        R.drawable.room0359,
        R.drawable.room0360,
        R.drawable.room0361,
        R.drawable.room0362,
        R.drawable.room0363,
        R.drawable.room0364,
        R.drawable.room0365,
        R.drawable.room0366,
        R.drawable.room0367,
        R.drawable.room0368,
        R.drawable.room0369,
        R.drawable.room0370,
        R.drawable.room0371,
        R.drawable.room0372,
        R.drawable.room0373,
        R.drawable.room0374,
        R.drawable.room0375,
        R.drawable.room0376,
        R.drawable.room0377,
        R.drawable.room0378,
        R.drawable.room0379,
        R.drawable.room0380,
        R.drawable.room0381,
        R.drawable.room0382,
        R.drawable.room0383,
        R.drawable.room0384,
        R.drawable.room0385,
        R.drawable.room0386,
        R.drawable.room0387,
        R.drawable.room0388,
        R.drawable.room0389,
        R.drawable.room0390,
        R.drawable.room0391,
        R.drawable.room0392,
        R.drawable.room0393,
        R.drawable.room0394,
        R.drawable.room0395,
        R.drawable.room0396,
        R.drawable.room0397,
        R.drawable.room0398,
        R.drawable.room0399,
        R.drawable.room0400
    )

}
