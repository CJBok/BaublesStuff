package md.zazpro.mod.client.events;

import org.lwjgl.input.Keyboard;

import md.zazpro.mod.common.network.PacketHandler;
import md.zazpro.mod.common.network.MessageMagnetToggle;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.MouseInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyHandler {
	
	public KeyBinding key_magnet = new KeyBinding("Toggle Equiped Magnet Ring", Keyboard.KEY_M, "Baubles Stuff");
	
	public KeyHandler() {
		ClientRegistry.registerKeyBinding(key_magnet);
	}
	
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void keyboardInput(KeyInputEvent event) {
		handleInputEvent();
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void mouseInput(MouseInputEvent event) {
		handleInputEvent();
	}
	
	
	public void handleInputEvent() {
		if (this.key_magnet.isPressed() && FMLClientHandler.instance().getClient().inGameHasFocus) {
			PacketHandler.INSTANCE.sendToServer(new MessageMagnetToggle());
		}
	}
}
