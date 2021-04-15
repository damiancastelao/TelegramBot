import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.network.fold

fun main() {
    println("Hello Bot!")

    val bot = bot {

        token = "1701880343:AAHdH2zYMwCUEYCrr3eaneDHlKTL5ucvtyg"

        dispatch {

            text {
                print("Chat ID: ")
                println(message.chat.id)
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = text)
            }
            command("para1") {

                val result = bot.sendMessage(chatId = ChatId.fromId(update.message!!.chat.id), text = "Para world!")

                result.fold(
                        {
                            // do something here with the response
                        },
                        {
                            // do something with the error
                        }
                )
            }
            command("arrancar1") {
                val markdownV2Text = """
                    *bold \*text*
                    _italic \*text_
                    __underline__
                    ~strikethrough~
                    *bold _italic bold ~italic bold strikethrough~ __underline italic bold___ bold*
                    [inline URL](http://www.example.com/)
                    [inline mention of a user](tg://user?id=123456789)
                    `inline fixed-width code`
                    ```kotlin
                    fun main() {
                        println("Hello Kotlin!")
                    }
                    ```
                """.trimIndent()
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = markdownV2Text,
                    parseMode = ParseMode.MARKDOWN_V2
                )
            }
        }
    }

    bot.startPolling()
}