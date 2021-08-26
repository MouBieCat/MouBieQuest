package moubiequest.core.itemstack.UI;

import moubiequest.api.itemstack.UI.GUIBuilder;
import moubiequest.api.itemstack.UI.button.UItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 代表一個介面建構器類
 * @author MoiBueCat
 */
public abstract class UInventoryBuilder
        implements GUIBuilder {

    /**
     * 代表一個介面大小
     */
    public enum InventorySize {

        ONE(9),     // 一行
        TWO(18),    // 兩行
        THREE(27),  // 三行
        FOUR(36),   // 四行
        FIVE(45),   // 五行
        SIX(54);    // 六行

        // 大小
        private final int size;

        /**
         * 建構子
         * @param size 大小
         */
        InventorySize(final int size) {
            this.size = size;
        }

        /**
         * 獲取大小
         * @return 大小
         */
        public final int getSize() {
            return this.size;
        }

        /**
         * 轉換成字串類型
         * @return 字串
         */
        @Override
        public final String toString() {
            return "InventorySize{" + "size=" + size + '}';
        }
    }

    // 介面本身
    protected final Inventory inventory;

    // 標題
    protected final String inventory_title;

    // 大小
    protected final InventorySize inventory_size;

    /**
     * 建構子
     * @param title 介面標題
     * @param size 介面大小
     */
    public UInventoryBuilder(final @NotNull String title, final @NotNull InventorySize size) {
        this.inventory_title = ChatColor.translateAlternateColorCodes('%', title);
        this.inventory_size = size;
        this.inventory = Bukkit.createInventory(this, this.inventory_size.getSize(), this.inventory_title);
    }

    /**
     * 獲取介面大小
     * @return 大小
     */
    public final InventorySize getGUISize() {
        return this.inventory_size;
    }

    /**
     * 獲取介面標題
     * @return 標題
     */
    @NotNull
    public final String getGUITitle() {
        return this.inventory_title;
    }

    /**
     * 添加一個按鈕到介面
     * @param uItem 介面物品實例
     * @return 當前的建構器
     */
    @NotNull
    public final GUIBuilder addUItem(final @NotNull UItem uItem) {
        this.inventory.setItem(uItem.getSlotId(), uItem.build());
        return this;
    }

    /**
     * 添加一個物品到介面
     * @param itemStack 物品
     * @return 當前的建構器
     */
    @NotNull
    public final GUIBuilder addItem(final @NotNull ItemStack itemStack) {
        this.inventory.addItem(itemStack);
        return this;
    }

    /**
     * 清除當前介面上的所有物品按鈕
     */
    public final void clearInventory() {
        final ItemStack airItemStack = new ItemStack(Material.AIR);
        for (int slot = 0; slot < this.inventory_size.getSize(); slot++)
            this.inventory.setItem(slot, airItemStack);
    }

    /**
     * Get the object's inventory.
     * @return The inventory.
     */
    @NotNull
    public final Inventory getInventory() {
        return this.inventory;
    }

    /**
     * 開啟介面
     * @param player 玩家
     */
    @Override
    public final void open(final @NotNull Player player) {
        this.initInventory(player);
        player.openInventory(this.inventory);
    }

    /**
     * 初始化介面
     * @param player 玩家
     */
    protected abstract void initInventory(final @NotNull Player player);

    /**
     * 代表當介面被點擊的事件
     * @param event 介面點擊事件
     */
    public abstract void clickInventory(final @NotNull InventoryClickEvent event);

}