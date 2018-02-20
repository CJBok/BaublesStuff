package md.zazpro.mod.common.network;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import io.netty.buffer.ByteBuf;
import md.zazpro.mod.common.baubles.base.RingBaseMagnet;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageMagnetToggle implements IMessage, IMessageHandler<MessageMagnetToggle, IMessage> {

	@Override
	public IMessage onMessage(MessageMagnetToggle message, MessageContext ctx) {
		if (ctx.side == Side.CLIENT)
			return null;
		
		NetHandlerPlayServer netHandler = (NetHandlerPlayServer) ctx.netHandler;
		EntityPlayerMP player = netHandler.player;
		
		IBaublesItemHandler baublesHandler = BaublesApi.getBaublesHandler(player);
		int slotCount = baublesHandler.getSlots();
		
		for (int slotID = 0 ; slotID < slotCount ; slotID++) {
			ItemStack tempItem = baublesHandler.getStackInSlot(slotID);
			if (tempItem != null && tempItem.getItem() instanceof RingBaseMagnet) {
				ItemStack item = baublesHandler.extractItem(slotID, 1, false);
				boolean magnetActive = item.getTagCompound().getBoolean("active");
				item.getTagCompound().setBoolean("active", !magnetActive);
				baublesHandler.insertItem(slotID, item, false);
				
				player.connection.sendPacket(new SPacketChat(new TextComponentString("Magnet " + (!magnetActive ? "Active" : "Inactive")), ChatType.GAME_INFO));
			}
		}
		
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
	}

	@Override
	public void toBytes(ByteBuf buf) {
	}

}
