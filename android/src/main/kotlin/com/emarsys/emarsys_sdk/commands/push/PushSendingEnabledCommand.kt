package com.emarsys.emarsys_sdk.commands.push

import com.emarsys.Emarsys
import com.emarsys.core.api.result.CompletionListener
import com.emarsys.emarsys_sdk.EmarsysCommand
import com.emarsys.emarsys_sdk.PushTokenStorage
import com.emarsys.emarsys_sdk.commands.ResultCallback

class PushSendingEnabledCommand(private val pushTokenStorage: PushTokenStorage) : EmarsysCommand {

    override fun execute(parameters: Map<String, Any?>?, resultCallback: ResultCallback) {
        val enable: Boolean = (parameters?.get("pushSendingEnabled") as? Boolean)
            ?: throw IllegalArgumentException("pushSendingEnabled must not be null")
        if (enable) {
            val pushToken = pushTokenStorage.pushToken
            if (pushToken != null) {
                Emarsys.push.setPushToken(pushTokenStorage.pushToken!!, CompletionListener {
                    resultCallback.invoke(null, it)
                })
            } else {
                throw IllegalArgumentException("PushToken must not be null")
            }
        } else {
            Emarsys.push.clearPushToken()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}