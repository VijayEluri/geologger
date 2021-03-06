import java.util.*;
import java.awt.geom.Rectangle2D;

public class GeoRegion { //implements Iterable

	ArrayList< GeoCoord > coords;

	public GeoRegion() {
		//this.coords = new GeoCoord[ 0 ];
		this.coords = new ArrayList< GeoCoord >();
	}

	public GeoRegion( GeoCoord... coordinates ) {
		this.coords = new ArrayList< GeoCoord >();
		for( GeoCoord coord : coordinates ) {
			this.coords.add( coord );
		}
	}

	public Rectangle2D.Double getBoundingBox() {
		boolean first = true;
		double lat_min, lat_max, long_min, long_max;
		lat_min = lat_max = long_min = long_max = 0;

		for( GeoCoord c : coords ) {
			if( first ) {
				lat_min = lat_max = c.getLatitude();
				long_min = long_max = c.getLongitude();
				first = false;
			}

			if( c.getLatitude()  < lat_min  ) lat_min  = c.getLatitude();
			if( c.getLatitude()  > lat_max  ) lat_max  = c.getLatitude();
			if( c.getLongitude() < long_min ) long_min = c.getLongitude();
			if( c.getLongitude() > long_max ) long_max = c.getLongitude();
		}

		return new Rectangle2D.Double( long_min, lat_min, long_max - long_min, lat_max - lat_min );
	}

	public void add( GeoCoord... coordinates ) {
		for( GeoCoord val : coordinates ) {
			coords.add( val );
		}
	}

	public void add( int index, GeoCoord coord ) {
		this.coords.add( index, coord );
	}

}
