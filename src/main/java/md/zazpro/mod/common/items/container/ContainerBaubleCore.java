package md.zazpro.mod.common.items.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.EnumHand;

public class ContainerBaubleCore extends Container {
	
	public ContainerBaubleCore(InventoryPlayer inventoryPlayer, EnumHand hand) {
		
		
		int i = 18;
		for (int l = 0; l < 3; ++l)
        {
            for (int j1 = 0; j1 < 9; ++j1)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i1, 8 + i1 * 18, 161 + i));
        }
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
