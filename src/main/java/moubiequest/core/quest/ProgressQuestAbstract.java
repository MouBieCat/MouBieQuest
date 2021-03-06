package moubiequest.core.quest;

import moubiequest.api.data.quest.ProgressQuestData;
import moubiequest.api.quest.ProgressQuest;
import moubiequest.api.quest.QuestType;
import moubiequest.core.quest.objects.Message;
import moubiequest.core.quest.objects.QItem;
import moubiequest.core.quest.objects.Status;
import moubiequest.core.quest.objects.Title;
import moubiequest.main.MouBieCat;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個帶有進度的任務類
 * @author MouBieCat
 */
public abstract class ProgressQuestAbstract
        extends QuestAbstract
        implements ProgressQuest {

    protected final int quest_progress;

    /**
     * 建構子
     * @param quest_type        任務類型
     * @param quest_key         任務識別名稱
     * @param quest_title       任務稱號
     * @param quest_message     任務消息
     * @param quest_status      任務狀態
     * @param quest_honor_point 任務榮譽點數
     * @param quest_progress 任務所需的進度次數
     */
    public ProgressQuestAbstract(final @NotNull QuestType quest_type,
                                 final @NotNull String quest_key,
                                 final @NotNull Title quest_title,
                                 final @NotNull Message quest_message,
                                 final @NotNull Status quest_status,
                                 final @NotNull QItem item,
                                 final int quest_honor_point,
                                 final int quest_progress) {
        super(quest_type, quest_key, quest_title, quest_message, quest_status, item, quest_honor_point);
        this.quest_progress = quest_progress;
    }

    /**
     * 或取進度任務需達成的次數
     * @return 所需次數
     */
    public final int getQuestProgress() {
        return this.quest_progress;
    }

    /**
     * 對玩家添加進度一次
     * @param player 玩家
     * @return 是否成功添加
     */
    public final boolean addPlayerQuestProgress(final @NotNull Player player) {
        if (this.isQuestEnable() && !this.isSuccess(player)) {
            final ProgressQuestData dataFile = MouBieCat.getInstance().getPlayerDataManager().get(player);
            dataFile.setProgress(this, dataFile.getProgress(this) + 1);
            return true;
        }
        return false;
    }

    /**
     * 對玩家進度清除歸零
     * @param player 玩家
     */
    public final void clearPlayerQuestProgress(final @NotNull Player player) {
        final ProgressQuestData dataFile = MouBieCat.getInstance().getPlayerDataManager().get(player);
        dataFile.setProgress(this, 0);
    }

    /**
     * 獲取該玩家目前達到的進度水平
     * @param player 玩家
     * @return 進度次數
     */
    public final int getPlayerQuestProgress(final @NotNull Player player) {
        final ProgressQuestData dataFile = MouBieCat.getInstance().getPlayerDataManager().get(player);
        return dataFile.getProgress(this);
    }

    /**
     * 判定玩家該任務是否已經達成
     * @param player 玩家
     * @return 是否達成
     */
    @Override
    public boolean isSuccess(final @NotNull Player player) {
        return (this.getPlayerQuestProgress(player) >= this.quest_progress);
    }

}
