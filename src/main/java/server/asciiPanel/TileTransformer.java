package server.asciiPanel;

public interface TileTransformer {
    public void transformTile(int x, int y, AsciiCharacterData data);
}