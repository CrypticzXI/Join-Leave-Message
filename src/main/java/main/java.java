package main;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class java extends JavaPlugin implements Listener {

    String hardcode_prefix = ChatColor.translateAlternateColorCodes('&', "&7[&a+&7/&c-&7] ");

    String lines = ChatColor.translateAlternateColorCodes('&', "&a----------&c----------");


    // Default

    boolean DefaultEnabled = this.getConfig().getBoolean("DefaultEnabled");

    String DefaultPermission = this.getConfig().getString("DefaultPermission");

    boolean DefaultPersonalJoinMessageEnabled = this.getConfig().getBoolean("DefaultPersonalJoinMessageEnabled");
    List<String> DefaultPersonalJoinMessage = this.getConfig().getStringList("DefaultPersonalJoinMessage");

    boolean DefaultJoinMessagePublicEnabled = this.getConfig().getBoolean("DefaultJoinMessagePublicEnabled");
    List<String> DefaultJoinMessagePublic = this.getConfig().getStringList("DefaultJoinMessagePublic");

    boolean DefaultJoinHasPlayedBeforeMessageEnabled = this.getConfig().getBoolean("DefaultJoinHasPlayedBeforeMessageEnabled");
    List<String> DefaultJoinHasPlayedBeforeMessage = this.getConfig().getStringList("DefaultJoinHasPlayedBeforeMessage");

    boolean DefaultLeaveMessagePublicEnabled = this.getConfig().getBoolean("DefaultLeaveMessagePublicEnabled");
    List<String> DefaultLeaveMessagePublic = this.getConfig().getStringList("DefaultLeaveMessagePublic");

    // End of Default

    // Vip1

    boolean Vip1Enabled = this.getConfig().getBoolean("Vip1Enabled");

    String Vip1Permission = this.getConfig().getString("Vip1Permission");

    boolean Vip1PersonalJoinMessageEnabled = this.getConfig().getBoolean("Vip1PersonalJoinMessageEnabled");
    List<String> Vip1PersonalJoinMessage = this.getConfig().getStringList("Vip1PersonalJoinMessage");

    boolean Vip1JoinMessagePublicEnabled = this.getConfig().getBoolean("Vip1JoinMessagePublicEnabled");
    List<String> Vip1JoinMessagePublic = this.getConfig().getStringList("Vip1JoinMessagePublic");

    boolean Vip1JoinHasPlayedBeforeMessageEnabled = this.getConfig().getBoolean("Vip1JoinHasPlayedBeforeMessageEnabled");
    List<String> Vip1JoinHasPlayedBeforeMessage = this.getConfig().getStringList("Vip1JoinHasPlayedBeforeMessage");

    boolean Vip1LeaveMessagePublicEnabled = this.getConfig().getBoolean("Vip1LeaveMessagePublicEnabled");
    List<String> Vip1LeaveMessagePublic = this.getConfig().getStringList("Vip1LeaveMessagePublic");

    // End of Vip1

    // Vip2

    boolean Vip2Enabled = this.getConfig().getBoolean("Vip2Enabled");

    String Vip2Permission = this.getConfig().getString("Vip2Permission");

    boolean Vip2PersonalJoinMessageEnabled = this.getConfig().getBoolean("Vip2PersonalJoinMessageEnabled");
    List<String> Vip2PersonalJoinMessage = this.getConfig().getStringList("Vip2PersonalJoinMessage");

    boolean Vip2JoinMessagePublicEnabled = this.getConfig().getBoolean("Vip2JoinMessagePublicEnabled");
    List<String> Vip2JoinMessagePublic = this.getConfig().getStringList("Vip2JoinMessagePublic");

    boolean Vip2JoinHasPlayedBeforeMessageEnabled = this.getConfig().getBoolean("Vip2JoinHasPlayedBeforeMessageEnabled");
    List<String> Vip2JoinHasPlayedBeforeMessage = this.getConfig().getStringList("Vip2JoinHasPlayedBeforeMessage");

    boolean Vip2LeaveMessagePublicEnabled = this.getConfig().getBoolean("Vip2LeaveMessagePublicEnabled");
    List<String> Vip2LeaveMessagePublic = this.getConfig().getStringList("Vip2LeaveMessagePublic");

    // End of Vip2

    // Staff

    boolean StaffEnabled = this.getConfig().getBoolean("StaffEnabled");

    String StaffPermission = this.getConfig().getString("StaffPermission");

    boolean StaffPersonalJoinMessageEnabled = this.getConfig().getBoolean("StaffPersonalJoinMessageEnabled");
    List<String> StaffPersonalJoinMessage = this.getConfig().getStringList("StaffPersonalJoinMessage");

    boolean StaffJoinMessagePublicEnabled = this.getConfig().getBoolean("StaffJoinMessagePublicEnabled");
    List<String> StaffJoinMessagePublic = this.getConfig().getStringList("StaffJoinMessagePublic");

    boolean StaffJoinHasPlayedBeforeMessageEnabled = this.getConfig().getBoolean("StaffJoinHasPlayedBeforeMessageEnabled");
    List<String> StaffJoinHasPlayedBeforeMessage = this.getConfig().getStringList("StaffJoinHasPlayedBeforeMessage");

    boolean StaffLeaveMessagePublicEnabled = this.getConfig().getBoolean("StaffLeaveMessagePublicEnabled");
    List<String> StaffLeaveMessagePublic = this.getConfig().getStringList("StaffLeaveMessagePublic");

    // End of Staff

    // Management

    boolean ManagementEnabled = this.getConfig().getBoolean("ManagementEnabled");

    String ManagementPermission = this.getConfig().getString("ManagementPermission");

    boolean ManagementPersonalJoinMessageEnabled = this.getConfig().getBoolean("ManagementPersonalJoinMessageEnabled");
    List<String> ManagementPersonalJoinMessage = this.getConfig().getStringList("ManagementPersonalJoinMessage");

    boolean ManagementJoinMessagePublicEnabled = this.getConfig().getBoolean("ManagementJoinMessagePublicEnabled");
    List<String> ManagementJoinMessagePublic = this.getConfig().getStringList("ManagementJoinMessagePublic");

    boolean ManagementJoinHasPlayedBeforeMessageEnabled = this.getConfig().getBoolean("ManagementJoinHasPlayedBeforeMessageEnabled");
    List<String> ManagementJoinHasPlayedBeforeMessage = this.getConfig().getStringList("ManagementJoinHasPlayedBeforeMessage");

    boolean ManagementLeaveMessagePublicEnabled = this.getConfig().getBoolean("ManagementLeaveMessagePublicEnabled");
    List<String> ManagementLeaveMessagePublic = this.getConfig().getStringList("ManagementLeaveMessagePublic");

    // End of Management

    //Other
    String AdminPermission = this.getConfig().getString("AdminPermission");

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info(lines);
        getLogger().info(hardcode_prefix + "Plugin Loaded.");
        getLogger().info(lines);

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * We register the EventListener here, when PlaceholderAPI is installed.
             * Since all events are in the main class (this class), we simply use "this"
             */
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            /*
             * We inform about the fact that PlaceholderAPI isn't installed and then
             * disable this plugin to prevent issues.
             */
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        getServer().getPluginManager().registerEvents(new OnJoinListener(), this);

        getServer().getPluginManager().registerEvents(new OnLeaveListener(), this);

        this.getCommand("jlm").setExecutor(new CommandReload());



        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(lines);
        getLogger().info(hardcode_prefix + "Plugin Unloaded.");
        getLogger().info(lines);
    }

    public class OnJoinListener implements Listener {

        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent e) {

            Player player = e.getPlayer();

            boolean hasPlayed = player.hasPlayedBefore();

            // End of Default
            if (DefaultEnabled) {
                if (player.isOp()){
                    return;
                }

                if (player.hasPermission(DefaultPermission)) {

                    if (DefaultPersonalJoinMessageEnabled) {

                        for (String message : DefaultPersonalJoinMessage) {
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                            player.sendMessage(Coloured);
                        }

                    }

                    if (hasPlayed) {

                        if (DefaultJoinHasPlayedBeforeMessageEnabled) {

                            for (String message : DefaultJoinHasPlayedBeforeMessage) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        } else {

                            for (String message : DefaultJoinMessagePublic) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        }
                    } else {

                        if (DefaultJoinMessagePublicEnabled) {

                            for (String message : DefaultJoinMessagePublic) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        }
                    }
                }
            }
            // End of Default

            // Vip1
            if (Vip1Enabled) {
                if (player.isOp()){
                    return;
                }

                if (player.hasPermission(Vip1Permission)) {

                    if (Vip1PersonalJoinMessageEnabled) {

                        for (String message : Vip1PersonalJoinMessage) {
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                            player.sendMessage(Coloured);
                        }

                    }

                    if (hasPlayed) {

                        if (Vip1JoinHasPlayedBeforeMessageEnabled) {

                            for (String message : Vip1JoinHasPlayedBeforeMessage) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        } else {

                            for (String message : Vip1JoinMessagePublic) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        }
                    } else {

                        if (Vip1JoinMessagePublicEnabled) {

                            for (String message : Vip1JoinMessagePublic) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        }
                    }
                }
            }
            // End of Vip1

            // Vip2
            if (Vip2Enabled) {
                if (player.isOp()){
                    return;
                }

                if (player.hasPermission(Vip2Permission)) {

                    if (Vip2PersonalJoinMessageEnabled) {

                        for (String message : Vip2PersonalJoinMessage) {
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                            player.sendMessage(Coloured);
                        }

                    }

                    if (hasPlayed) {

                        if (Vip2JoinHasPlayedBeforeMessageEnabled) {

                            for (String message : Vip2JoinHasPlayedBeforeMessage) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        } else {

                            for (String message : Vip2JoinMessagePublic) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        }
                    } else {

                        if (Vip2JoinMessagePublicEnabled) {

                            for (String message : Vip2JoinMessagePublic) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        }
                    }
                }
            }
            // End of Vip2

            // Staff
            if (StaffEnabled) {
                if (player.isOp()){
                    return;
                }

                    if (player.hasPermission(StaffPermission)) {

                        if (StaffPersonalJoinMessageEnabled) {

                            for (String message : StaffPersonalJoinMessage) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                player.sendMessage(Coloured);
                            }

                        }

                        if (hasPlayed) {

                            if (StaffJoinHasPlayedBeforeMessageEnabled) {

                                for (String message : StaffJoinHasPlayedBeforeMessage) {
                                    message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                    String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                    Bukkit.getServer().broadcastMessage(Coloured);
                                }

                            } else {

                                for (String message : StaffJoinMessagePublic) {
                                    message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                    String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                    Bukkit.getServer().broadcastMessage(Coloured);
                                }

                            }
                        } else {

                            if (StaffJoinMessagePublicEnabled) {

                                for (String message : StaffJoinMessagePublic) {
                                    message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                    String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                    Bukkit.getServer().broadcastMessage(Coloured);
                                }

                            }
                        }
                    }
            }
            // End of Staff

            // Management
            if (ManagementEnabled) {

                if (player.hasPermission(ManagementPermission)) {

                    if (ManagementPersonalJoinMessageEnabled) {

                        for (String message : ManagementPersonalJoinMessage) {
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                            player.sendMessage(Coloured);
                        }

                    }

                    if (hasPlayed) {

                        if (ManagementJoinHasPlayedBeforeMessageEnabled) {

                            for (String message : ManagementJoinHasPlayedBeforeMessage) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                player.sendMessage(Coloured);
                            }

                        } else {

                            for (String message : ManagementJoinMessagePublic) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        }
                    } else {

                        if (ManagementJoinMessagePublicEnabled) {

                            for (String message : ManagementJoinMessagePublic) {
                                message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                                String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                                Bukkit.getServer().broadcastMessage(Coloured);
                            }

                        }
                    }
                }
            }
            // End of Management
        }
    }

    public class OnLeaveListener implements Listener {

        @EventHandler
        public void onPlayerLeave(PlayerQuitEvent e) {

            Player player = e.getPlayer();

            // Default
            if (DefaultEnabled) {

                if (player.hasPermission(DefaultPermission)) {

                    if (DefaultLeaveMessagePublicEnabled) {

                        for (String message : DefaultLeaveMessagePublic) {
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                            Bukkit.getServer().broadcastMessage(Coloured);
                        }

                    }

                }

            }
            // End of Default

            // Vip1
            if (Vip1Enabled) {

                if (player.hasPermission(Vip1Permission)) {

                    if (Vip1LeaveMessagePublicEnabled) {

                        for (String message : Vip1LeaveMessagePublic) {
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                            Bukkit.getServer().broadcastMessage(Coloured);
                        }

                    }

                }

            }
            // End of Vip1

            // Vip2
            if (Vip2Enabled) {

                if (player.hasPermission(Vip2Permission)) {

                    if (Vip2LeaveMessagePublicEnabled) {

                        for (String message : Vip2LeaveMessagePublic) {
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                            Bukkit.getServer().broadcastMessage(Coloured);
                        }

                    }

                }

            }
            // End of Vip2

            // Staff
            if (StaffEnabled) {

                if (player.hasPermission(StaffPermission)) {

                    if (StaffLeaveMessagePublicEnabled) {

                        for (String message : StaffLeaveMessagePublic) {
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                            Bukkit.getServer().broadcastMessage(Coloured);
                        }

                    }

                }

            }
            // End of Staff

            // Management
            if (ManagementEnabled) {

                if (player.hasPermission(ManagementPermission)) {

                    if (ManagementLeaveMessagePublicEnabled) {

                        for (String message : ManagementLeaveMessagePublic) {
                            message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
                            String Coloured = ChatColor.translateAlternateColorCodes('&', message);
                            Bukkit.getServer().broadcastMessage(Coloured);
                        }

                    }

                }

            }
            // End of Management

        }
    }
    public class CommandReload implements CommandExecutor {
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

            if (sender instanceof Player) {
                Player player = (Player) sender;

                if (label.equalsIgnoreCase("jlm")) {

                    if(args.length == 0){
                        String msg = ChatColor.translateAlternateColorCodes('&', "&cCommand Not Found, Try /jlm help.");
                        sender.sendMessage(hardcode_prefix + msg);
                    }

                    else if (args[0].equalsIgnoreCase("reload")) {
                        if (player.hasPermission(AdminPermission)) {
                            reloadConfig();
                            String msg = ChatColor.translateAlternateColorCodes('&', "&fConfig reloaded Correctly.");
                            player.sendMessage(hardcode_prefix + msg);
                        } else {
                            String msg = ChatColor.translateAlternateColorCodes('&', "&cNo Permission.");
                            player.sendMessage(hardcode_prefix + msg);
                        }
                    }

                    else if (args[0].equalsIgnoreCase("help")) {
                        if (player.hasPermission(AdminPermission)) {
                            String msg = ChatColor.translateAlternateColorCodes('&', "&aHelp &cMenu");
                            String msg2 = ChatColor.translateAlternateColorCodes('&', "/jlm reload");
                            player.sendMessage(hardcode_prefix + msg);
                            player.sendMessage(hardcode_prefix + msg2);
                        } else {
                            String msg = ChatColor.translateAlternateColorCodes('&', "&cNo Permission.");
                            player.sendMessage(hardcode_prefix + msg);
                        }
                    }

                    return true;
                } else {
                    sender.sendMessage(hardcode_prefix + "You cannot use this command from console.");
                }

                return true;
            }
            return true;
        }
    }
}