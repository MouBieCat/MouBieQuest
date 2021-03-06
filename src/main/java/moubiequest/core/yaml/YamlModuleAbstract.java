package moubiequest.core.yaml;

import moubiequest.api.yaml.YamlSection;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 該類可用於操作與獲取YAML物件資料
 * @author MouBieCat
 */
public abstract class YamlModuleAbstract
        extends FileModuleAbstract
        implements YamlSection {

    /**
     * 建構子
     * @param path      檔案路徑
     * @param name      檔案
     * @param isNewFile 是否新創建
     */
    public YamlModuleAbstract(final @NotNull String path, final @NotNull String name, final boolean isNewFile) {
        super(path, name, isNewFile);
        this.configuration = YamlConfiguration.loadConfiguration(this.file);
    }

    /**
     * 在指定路徑獲取某樣物件
     * @param var1 路徑
     * @return 物件
     */
    @Nullable
    public final Object get(final @NotNull String var1) {
        return this.configuration.get(var1);
    }

    /**
     * 在指定路徑獲取 boolean
     * @param var1 路徑
     * @return Boolean obj
     */
    public final boolean getBoolean(final @NotNull String var1) {
        return this.configuration.getBoolean(var1);
    }

    /**
     * 在指定路徑獲取 int
     * @param var1 路徑
     * @return Integer obj
     */
    public final int getInt(final @NotNull String var1) {
        return this.configuration.getInt(var1);
    }

    /**
     * 在指定路徑獲取 double
     * @param var1 路徑
     * @return Double obj
     */
    public final double getDouble(final @NotNull String var1) {
        return this.configuration.getDouble(var1);
    }

    /**
     * 在指定路徑獲取 String
     * @param var1 路徑
     * @return String obj
     */
    @NotNull
    public final String getString(final @NotNull String var1) {
        final String getString = this.configuration.getString(var1);
        return (getString != null) ? getString : "§4ERROR";
    }

    /**
     * 在指定路徑獲取 ItemStack
     * @param var1 路徑
     * @return ItemStack obj
     */
    @NotNull
    public final ItemStack getItemStack(final @NotNull String var1) {
        final ItemStack itemStack = this.configuration.getItemStack(var1);
        return itemStack != null ? itemStack : new ItemStack(Material.AIR);
    }

    /**
     * 在指定路徑獲取 List<Boolean>
     * @param var1 路徑
     * @return List<Boolean> obj
     */
    @NotNull
    public final List<Boolean> getBooleanList(final @NotNull String var1) {
        return this.configuration.getBooleanList(var1);
    }

    /**
     * 在指定路徑獲取 List<Double>
     * @param var1 路徑
     * @return List<Double> obj
     */
    @NotNull
    public final List<Double> getDoubleList(final @NotNull String var1) {
        return this.configuration.getDoubleList(var1);
    }

    /**
     * 在指定路徑獲取 List<Float>
     * @param var1 路徑
     * @return List<Float> obj
     */
    @NotNull
    public final List<Float> getFloatList(final @NotNull String var1) {
        return this.configuration.getFloatList(var1);
    }

    /**
     * 在指定路徑獲取 List<Byte>
     * @param var1 路徑
     * @return List<Byte> obj
     */
    @NotNull
    public final List<Byte> getByteList(final @NotNull String var1) {
        return this.configuration.getByteList(var1);
    }

    /**
     * 在指定路徑獲取 List<Integer>
     * @param var1 路徑
     * @return List<Integer> obj
     */
    @NotNull
    public final List<Integer> getIntegerList(final @NotNull String var1) {
        return this.configuration.getIntegerList(var1);
    }

    /**
     * 在指定路徑獲取 List<String>
     * @param var1 路徑
     * @return List<String> obj
     */
    @NotNull
    public final List<String> getStringList(final @NotNull String var1) {
        return this.configuration.getStringList(var1);
    }

}
