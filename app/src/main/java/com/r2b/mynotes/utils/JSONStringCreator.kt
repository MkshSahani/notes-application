package com.r2b.mynotes.utils

import android.util.Log
import com.r2b.mynotes.constants.NoteAppConstants
import java.lang.StringBuilder

object JSONStringCreator {

    private val TAG: String = NoteAppConstants.TAG + JSONStringCreator.javaClass.simpleName

    fun createJSONString(keyValuePairMap: Map<String, String>) : String? {
        try {
            val jsonStringBuilder: StringBuilder = StringBuilder()
            jsonStringBuilder.append("{")
            val numberOfEntries = keyValuePairMap.keys.size
            var counter = 0
            for(k in keyValuePairMap.keys) {
                jsonStringBuilder.append("\"${k}\":\"${keyValuePairMap[k]}\"")
                counter++
                if(counter < numberOfEntries) {
                    jsonStringBuilder.append(",")
                }
            }
            jsonStringBuilder.append("}")
            val jsonString: String = jsonStringBuilder.toString()
            Log.i(TAG, "Build json string :: $jsonString")
            return jsonString
        } catch (ex: Exception) {
            Log.i(TAG, "Error while creating json string")
            return null;
        }
    }

}