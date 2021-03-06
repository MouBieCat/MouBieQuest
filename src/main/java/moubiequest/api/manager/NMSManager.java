package moubiequest.api.manager;

import moubiequest.api.nms.Handler;
import moubiequest.api.nms.NBTHandler;
import moubiequest.api.nms.ParticleHandler;
import moubiequest.core.manager.nms.HandlerManager;
import org.jetbrains.annotations.NotNull;

/**
 * 記錄所有有關 nms 操作類的管理器介面
 * @author MouBieCat
 */
public interface NMSManager
        extends Manager<HandlerManager.NMSHandlerType, Handler> {

    /**
     * 獲取操作NBTTag的介面類
     * @return NBTHandler
     */
    @NotNull NBTHandler getNbtHandler();

    /**
     * 獲取操作粒子特效的介面類
     * @return NBTHandler
     */
    @NotNull ParticleHandler getParticleHandler();

}
