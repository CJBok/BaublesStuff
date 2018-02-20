package md.zazpro.mod.integration;

import net.minecraft.entity.Entity;
import vazkii.botania.common.block.subtile.functional.SubTileSolegnolia;

public class Botania
{
	
	public static boolean hasSolegnoliaAround(Entity e)
	{
		return SubTileSolegnolia.hasSolegnoliaAround(e);
	}

}
