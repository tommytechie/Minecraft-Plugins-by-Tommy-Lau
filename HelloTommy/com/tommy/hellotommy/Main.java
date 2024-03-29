package com.tommy.hellotommy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


//Driver Program
public class Main extends JavaPlugin {
	
	
	public SwearListener ls = new SwearListener(); //SwearListener
    
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("explode")) {
			Player player = (Player)sender;
			
			player.sendMessage(player.getName() + " BOOM!!");
			
			TNTPrimed tnt = (TNTPrimed)player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
			tnt.setFuseTicks(0);
			return true;
		}
		return super.onCommand(sender, command, label, args);
	}
	
	@Override
	public void onEnable() {
		getLogger().info("HELLO WORLD!!!!! TOMMY");
		PluginManager pm = getServer().getPluginManager();
		MyFirstListener listener = new MyFirstListener(this);
		
		pm.registerEvents(listener, this);
		
		getServer().getPluginManager().registerEvents(ls, this); //SwearListener
	}
	
	
	
	@Override
	public void onDisable() {
		getLogger().info("BYE BYE WORLD!");
	}
}
