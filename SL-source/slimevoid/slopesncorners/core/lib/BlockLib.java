package slimevoid.slopesncorners.core.lib;

public class BlockLib {

	public static final int		MAX_DAMAGE				= 4096;
	public static final int		MAX_TILES				= 6;
	public static final int		BLOCK_SLOPES_ID			= 0;
	public static final int		BLOCK_SIDES_ID			= 1;
	public static final int		BLOCK_OBLICS_ID			= 2;
	public static final int		BLOCK_TRIPOINT_ID		= 3;
	public static final int		BLOCK_HALF_SLOPE_ID		= 4;
	public static final int		BLOCK_POINT_SLOPE_ID	= 5;

	public static final String	DEFAULT_ICON			= CoreLib.MOD_RESOURCES + ":default";

	public static int getBlockDamage(int blockMetadata, short slopeIndex) {
		return slopeIndex % MaterialsLib.getSize() + (blockMetadata << 12);
	}

}
